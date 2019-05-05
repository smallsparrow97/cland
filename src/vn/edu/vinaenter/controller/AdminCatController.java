package vn.edu.vinaenter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.bean.Category;
import vn.edu.vinaenter.model.dao.CategoryDAO;

@Controller
@RequestMapping("admin/cat")
public class AdminCatController {
	
	@Autowired
	private CategoryDAO catDAO;
	
	@GetMapping("index")
	public String index(ModelMap modelMap) {
		List<Category> listCat = catDAO.getItems();
		modelMap.addAttribute("listCat", listCat);
		return "cland.admin.cat.index";
	}
	
	@GetMapping("add")
	public String add() {
		return "cland.admin.cat.add";
	}
	
	@PostMapping("add")
	public String add(@Valid @ModelAttribute("objCat") Category objCat, BindingResult br, RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "cland.admin.cat.add";
		}
		if (catDAO.addItem(objCat) > 0) {
			ra.addFlashAttribute("msgSuccess", Defines.MSG_ADD_SUCCESS);
			return "redirect:/admin/cat/index";
		} else {
			ra.addFlashAttribute("msgError", Defines.MSG_ERROR);
			return "redirect:/admin/cat/add";
		}
		
	}
	
	//@GetMapping("edit")
	@RequestMapping(value="/edit/{cid}")
	public String edit(@PathVariable("cid") int cid, ModelMap modelMap) {
		Category objCat = catDAO.getItem(cid);
		modelMap.addAttribute("objCat", objCat);
		return "cland.admin.cat.edit";
	}
	
	@PostMapping("edit")
	public String edit(@Valid @ModelAttribute("objCat") Category objCat, BindingResult br, RedirectAttributes ra) {
		if (br.hasErrors()) {
			return "cland.admin.cat.edit";
		}
		if (catDAO.editItem(objCat) > 0) {
			ra.addFlashAttribute("msgSuccess", Defines.MSG_UPDATE_SUCCESS);
			return "redirect:/admin/cat/index";
		} else {
			ra.addFlashAttribute("msgError", Defines.MSG_ERROR);
			return "redirect:/admin/cat/index";
		}
	}
	
	@RequestMapping(value="/del/{cid}")
	public String del(@PathVariable("cid") int cid, RedirectAttributes ra) {
		if (catDAO.delItem(cid) > 0) {
			ra.addFlashAttribute("msgSuccess", Defines.MSG_DELETE_SUCCESS);
			return "redirect:/admin/cat/index";
		} else {
			ra.addFlashAttribute("msgError", Defines.MSG_ERROR);
			return "redirect:/admin/cat/index";
		}
	}

}
