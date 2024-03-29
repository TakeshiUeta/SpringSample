package com.Example.demothimeleaf.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Example.demothimeleaf.domain.user.model.MUser;
import com.Example.demothimeleaf.domain.user.service.UserService;
import com.Example.demothimeleaf.form.UserListForm;

@Controller
@RequestMapping("/user")
public class UserListController {
	@Autowired
	private UserService userService;
	@Autowired
	private ModelMapper modelMapper;

	/**ユーザー一覧画面を表示*/
	@GetMapping("/list")
	public String getUserList(@ModelAttribute UserListForm form,Model model) {
		//formをＭuserに変換
		MUser user = modelMapper.map(form,MUser.class);
		//ユーザー取得
		List<MUser> userList = userService.getUsers(user);
		//modelに登録
		model.addAttribute("userList",userList);
		//ユーザー一覧画面を表示
		return "/user/list";
	}

	/**ユーザー検索処理*/
	@PostMapping("/list")
	public String postuserList(@ModelAttribute UserListForm form,Model model) {
		//formをＭuserに変換
		MUser user = modelMapper.map(form,MUser.class);
		//ユーザー検索
		List<MUser> userList = userService.getUsers(user);
		//modelに登録
		model.addAttribute("userList",userList);
		//ユーザー一覧画面を表示
		return "/user/list";
	} 
}
