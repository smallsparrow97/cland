package vn.edu.vinaenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestPass {
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("test-pass")
	public @ResponseBody String index() {
		return encoder.encode("123456");
	}
}
