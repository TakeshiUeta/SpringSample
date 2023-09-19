package com.Example.demothimeleaf.form;

import java.util.Date;

import lombok.Data;

@Data
public class UserDetailForm {
	private String userId;//ユーザーID
	private String password;//パスワード
	private String userName;//ユーザー名
	private Date birthday;//誕生日
	private Integer age;//年齢
	private Integer gender;//性別
	private Integer departmentId;//部署Id
	private String role;//ロール
}
