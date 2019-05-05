package vn.edu.vinaenter.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.bean.Contact;
import vn.edu.vinaenter.model.bean.User;
import vn.edu.vinaenter.model.dao.ContactDAO;

@Controller
@RequestMapping("admin/contact")
public class AdminContactController {
	
	@Autowired
	private ContactDAO contactDAO;
	
	
	@GetMapping("")
	public String index(ModelMap modelMap) {
		List<Contact> listContact = contactDAO.getItems();
		modelMap.addAttribute("listContact", listContact);
		return "cland.admin.contact.index";
	}
	
	
	@GetMapping("del/{cid}")
	public String del(@PathVariable("cid") int cid, RedirectAttributes ra) {
		if (contactDAO.delItem(cid) > 0) {
			ra.addFlashAttribute("msgSuccess", Defines.MSG_DELETE_SUCCESS);
			return "redirect:/admin/contact";
		} else {
			ra.addFlashAttribute("msgError", Defines.MSG_ERROR);
			return "redirect:/admin/contact";
		}
	}
}
