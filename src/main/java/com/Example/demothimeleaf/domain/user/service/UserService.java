package com.Example.demothimeleaf.domain.user.service;

import java.util.List;

import com.Example.demothimeleaf.domain.user.model.MUser;

public interface UserService {
	/* ユーザー登録 **/
	public void signup(MUser mUser);

	/* ユーザー取得 **/
	public List<MUser> getUsers(MUser user);

	/* ユーザー1件表示 **/
	public MUser getUserOne(String userId);

	/* ユーザー更新 **/
	public void updateUserOne(String userId, String password, String userName);
	/* ユーザー削除 **/
	public void deleteUserOne(String userId);
}
