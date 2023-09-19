package com.Example.demothimeleaf.controller;

import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Example.demothimeleaf.application.service.UserApplicationService;
import com.Example.demothimeleaf.domain.user.model.MUser;
import com.Example.demothimeleaf.domain.user.service.UserService;
import com.Example.demothimeleaf.form.GroupOrder;
import com.Example.demothimeleaf.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {
	@Autowired
	private UserApplicationService userApplicationService;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserService userService;
	
	/**ユーザー登録画面を表示*/
	@GetMapping("/signup")
	public String getSignup(Model model,Locale locale,@ModelAttribute SignupForm form) {
		//性別を取得
		Map<String, Integer> genderMap = userApplicationService.getGenderMap();
		model.addAttribute("genderMap",genderMap);
		//ユーザー登録画面に遷移
		return "user/signup";
	}
	
	/**ユーザー登録処理*/
	@PostMapping("/signup")
	public String postSignup(Model model,Locale locale,@ModelAttribute @Validated(GroupOrder.class) SignupForm form,BindingResult bindingResult) {
		//入力チェック処理
		if(bindingResult.hasErrors()) {
			//NG:ユーザー登録画面に戻ります
			return getSignup(model, locale, form);
		}
		
		log.info(form.toString());
		
		//formをMuserクラスに変換
		MUser mUser = modelMapper.map(form,MUser.class);
		//ユーザー登録
		userService.signup(mUser);
		//ログイン画面にリダイレクト
		return "redirect:/login";
	}
}
