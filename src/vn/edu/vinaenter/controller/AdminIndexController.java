package vn.edu.vinaenter.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.edu.vinaenter.model.bean.Land;
import vn.edu.vinaenter.model.bean.User;
import vn.edu.vinaenter.model.dao.CategoryDAO;
import vn.edu.vinaenter.model.dao.LandDAO;
import vn.edu.vinaenter.model.dao.UserDAO;

@Controller
@RequestMapping("admin")
public class AdminIndexController { 
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private LandDAO	landDAO;
	
	@GetMapping("")
	public String index(Principal principal, HttpSession session, ModelMap modelMap) {
		
		String username = principal.getName();
		//System.out.println("username: " + username);
		User objUserLogin = userDAO.getItem(username);
		session.setAttribute("objUserLogin", objUserLogin);
		
		int numberCat = categoryDAO.countNumberCat();
		int numberLand = landDAO.countNumberLand();
		int numberUser = userDAO.countNumberUser();
		
		modelMap.addAttribute("numberCat", numberCat);
		modelMap.addAttribute("numberLand", numberLand);
		modelMap.addAttribute("numberUser", numberUser);
		
		return "cland.admin.index.index";
	}

}
