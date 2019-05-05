package vn.edu.vinaenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.bean.Category;
import vn.edu.vinaenter.model.bean.Contact;
import vn.edu.vinaenter.model.bean.Land;
import vn.edu.vinaenter.model.dao.CategoryDAO;
import vn.edu.vinaenter.model.dao.ContactDAO;
import vn.edu.vinaenter.model.dao.LandDAO;

@Controller
public class PublicIndexController {

	@Autowired
	private LandDAO landDAO;
	
	@Autowired
	private CategoryDAO catDAO;
	
	@Autowired
	private ContactDAO contactDAO;
	
	// những đối tượng chung, ModelAttribute chia sẻ cho những phương thức trong class có trả về view
	@ModelAttribute
	public void commonObject(ModelMap modelMap) {
		List<Category> listCat = catDAO.getItems();
		List<Land> listHotNews = landDAO.getHotLand(5);
		modelMap.addAttribute("landDAO", landDAO);
		modelMap.addAttribute("listCat", listCat);
		modelMap.addAttribute("listHotNews", listHotNews);
	}
	
	@GetMapping({"", "/{page}"})
	public String index(ModelMap modelMap, @PathVariable(name = "page" , required = false) Integer page) {
		if (page == null) {
			page = 1;
		}
		int totalLand = landDAO.totalLand();
		int row_count = Defines.ROW_COUNT;
		int sumPage = (int) Math.ceil((float) totalLand / row_count);
		int offset = (page - 1) * row_count;
		List<Land> listLand = landDAO.getItems(offset, row_count);
		List<Land> listHotLand = landDAO.getHotLand(3);
		
		modelMap.addAttribute("listLand", listLand);
		modelMap.addAttribute("listHotLand", listHotLand);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("sumPage", sumPage);
		modelMap.addAttribute("catDAO", catDAO);
		
		return "cland.public.index.index";
	}
	
	@GetMapping({"danh-muc/{name}-{cid}", "danh-muc/{name}-{cid}/{page}"})
	public String cat(ModelMap modelMap, @PathVariable(name = "cid") int cid, 
			@PathVariable (name = "page" , required = false) Integer page) {
		
		if (page == null) {
			page = 1;
		}
		
		int totalLand = landDAO.totalLand(cid);
		int rowCount = Defines.ROW_COUNT;
		int sumPage = (int) Math.ceil((float) totalLand/rowCount);
		int offset = (page-1) * rowCount;
				
		List<Land> listLand = landDAO.getItemByCatId(cid, offset, rowCount);
		Category objCat = catDAO.getItem(cid);
		modelMap.addAttribute("objCat", objCat);
		modelMap.addAttribute("listLand", listLand);
		modelMap.addAttribute("sumPage", sumPage);
		modelMap.addAttribute("page", page);
		
		return "cland.public.index.cat";
	}
	
	@GetMapping("news/{name}-{lid}.html")
	public String single(ModelMap modelMap, @PathVariable(name = "lid") int lid) {
		
		Land objLand = landDAO.getItem(lid);
		// tăng lượt view
		landDAO.increaseView(objLand);
		
		List<Land> listRelateLand = landDAO.getRelateLand(lid, objLand.getCid());
		
		modelMap.addAttribute("objLand", objLand);
		modelMap.addAttribute("listRelateLand", listRelateLand);
		return "cland.public.index.single";
	}
	
	@GetMapping("contact")
	public String contact() {
		return "cland.public.index.contact";
	}
	
	@PostMapping("contact")
	public String contact(@ModelAttribute("objContact") Contact objContact, RedirectAttributes ra) {
		if (contactDAO.addItem(objContact) > 0) {
			ra.addFlashAttribute("msgSuccess", Defines.MSG_ADD_SUCCESS);
			return "redirect:/contact.html";
		} else {
			ra.addFlashAttribute("msgError", Defines.MSG_ERROR);
			return "redirect:/contact.html";
		}
	}
}
