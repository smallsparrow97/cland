package vn.edu.vinaenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
	@GetMapping("404.html")
	public String index() {
		return "error/404";
	}
	
	@GetMapping("403.html")
	public String index403() {
		return "error/403";
	}
}
