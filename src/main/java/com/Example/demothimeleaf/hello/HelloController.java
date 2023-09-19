package com.Example.demothimeleaf.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@Autowired
	HelloService service; 
	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
	@PostMapping("/hello")
	public String postHello(@RequestParam("text1")String str,Model model){
		model.addAttribute("str",str);
		return "hello";
	}
	
	@PostMapping("/hello/db")
	public String postDBRequest(@RequestParam("text2")String id,Model model) {
		
		//1件検索
		Employee employee = service.getEmployee(id); 
		
		//検索結果をモデルに登録
		model.addAttribute(employee);
		
		//db.htlに遷移
		return "/hello/db";
	}
}
