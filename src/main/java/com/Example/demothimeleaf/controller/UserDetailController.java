package com.Example.demothimeleaf.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Example.demothimeleaf.domain.user.model.MUser;
import com.Example.demothimeleaf.domain.user.service.UserService;
import com.Example.demothimeleaf.form.UserDetailForm;

@Controller
@RequestMapping("/user")
public class UserDetailController {
	@Autowired
	private UserService userService;
	@Autowired
	private ModelMapper modelMapper;
	
	/*動的URL（この場合userIdが変数のためURLが変わる。）
	:.+の部分は正規表現（Idがメールアドレスのため）
	@PathVariableで変数の値を受け取る
	 そうでない場合は{userId}で問題ない。（変数は{}か[]で括る）*/
	@GetMapping("/detail/{userId:.+}")
	public String getUserDetail(Model model,UserDetailForm form,@PathVariable("userId")String userId) {
		//ユーザー1件表示
		MUser user = userService.getUserOne(userId);
		user.setPassword(null);
		//MUserをformに変換
		form=modelMapper.map(user, UserDetailForm.class);
		//modelに登録
		model.addAttribute("userDetailForm",form);
		//ユーザー詳細画面に遷移
		return "/user/detail";
	}
	
	/**PostMappingのparams属性
	 * thymeleaf側のボタンタグでname属性と同じものを指定する
	 * こうすると同じformタグのボタンでもコントローラー側で受け取るメソッドを変更することができる
	 * 下記だとpostメソッドは二つあるが受け渡しはparams＝ボタンタグのname
	 * */
	
	@PostMapping(value="/detail",params="update")
	public String updateUser(UserDetailForm form,Model model) {
		//ユーザー更新
		userService.updateUserOne(form.getUserId(), form.getPassword(), form.getUserName());
		//ユーザー一覧画面にリダイレクト
		return "redirect:/user/list";
	}
	
	@PostMapping(value="/detail",params="delete")
	public String daleteUser(UserDetailForm form,Model model) {
		//ユーザー削除
		userService.deleteUserOne(form.getUserId());
		//ユーザー一覧画面にリダイレクト
		return "redirect:/user/list";
	}
}
