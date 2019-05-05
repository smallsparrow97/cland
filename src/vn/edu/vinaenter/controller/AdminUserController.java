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
import vn.edu.vinaenter.model.bean.User;
import vn.edu.vinaenter.model.dao.UserDAO;

@Controller
@RequestMapping("admin/user")
public class AdminUserController {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("index")
	public String index(ModelMap modelMap) {
		List<User> listUser = userDAO.getItems();
		modelMap.addAttribute("listUser", listUser);
		return "cland.admin.user.index";
	}
	
	@GetMapping("add")
	public String add() {
		return "cland.admin.user.add";
	}
	
	@PostMapping("add")
	public String add(@ModelAttribute("objUser") User objUser, RedirectAttributes ra) {
		
		// mã hóa mật khẩu
		objUser.setPassword(encoder.encode(objUser.getPassword()));
		
		if (userDAO.addItem(objUser) > 0) {
			ra.addFlashAttribute("msgSuccess", Defines.MSG_ADD_SUCCESS);
			return "redirect:/admin/user/index";
		} else {
			ra.addFlashAttribute("msgError", Defines.MSG_ERROR);
			return "redirect:/admin/user/add";
		}
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") int id, ModelMap modelMap, HttpSession session) {
		User objUser = userDAO.getItem(id);
		User objUserLogin = (User) session.getAttribute("objUserLogin");
		modelMap.addAttribute("objUser", objUser);
		modelMap.addAttribute("objUserLogin", objUserLogin);
		
		return "cland.admin.user.edit";
	}
	
	@PostMapping("edit")
	public String edit(@ModelAttribute("objUser") User objUser, RedirectAttributes ra) {
		// nếu nhập mật khẩu thì update password, nếu không thì không update password
		if (!"".equals(objUser.getPassword())) {
			// mã hóa mật khẩu
			objUser.setPassword(encoder.encode(objUser.getPassword()));
			
			if (userDAO.editItem(objUser) > 0) {
				ra.addFlashAttribute("msgSuccess", Defines.MSG_UPDATE_SUCCESS);
				return "redirect:/admin/user/index";
			} else {
				ra.addFlashAttribute("msgError", Defines.MSG_ERROR);
				return "redirect:/admin/user/index";
			}
		} else {
			if (userDAO.editItem2(objUser) > 0) {
				ra.addFlashAttribute("msgSuccess", Defines.MSG_UPDATE_SUCCESS);
				return "redirect:/admin/user/index";
			} else {
				ra.addFlashAttribute("msgError", Defines.MSG_ERROR);
				return "redirect:/admin/user/index";
			}
		}
		
	}
	
	@GetMapping("del/{id}")
	public String del(@PathVariable("id") int id, RedirectAttributes ra) {
		if (userDAO.delItem(id) > 0) {
			ra.addFlashAttribute("msgSuccess", Defines.MSG_DELETE_SUCCESS);
			return "redirect:/admin/user/index";
		} else {
			ra.addFlashAttribute("msgError", Defines.MSG_ERROR);
			return "redirect:/admin/user/index";
		}
	}
}
