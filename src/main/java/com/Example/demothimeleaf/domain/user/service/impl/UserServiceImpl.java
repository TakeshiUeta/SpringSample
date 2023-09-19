package com.Example.demothimeleaf.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Example.demothimeleaf.domain.user.model.MUser;
import com.Example.demothimeleaf.domain.user.service.UserService;
import com.Example.demothimeleaf.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper mapper;
	
	/**ユーザー登録*/
	@Override
	public void signup(MUser mUser) {
		mUser.setDepartmentId(1);//部署
		mUser.setRole("ROLE_GENERAL");//ロール
		mapper.insertOne(mUser);
	}
	
	/**ユーザー取得*/
	@Override
	/**ユーザー取得*/
	public List<MUser> getUsers(MUser user){
		 List<MUser> mUserList = mapper.findMany(user);
		 return mUserList;
	}
	
	/**ユーザー1件表示*/
	@Override
	public MUser getUserOne(String userId) {
		return mapper.findOne(userId);
	}
	
	/** ユーザー更新 */
	@Override
	public void updateUserOne(String userId, String password, String userName) {
		mapper.updateOne(userId, password, userName);
	}
	
	/** ユーザー削除 */
	@Override
	public void deleteUserOne(String userId) {
		mapper.deleteOne(userId);
	}
}
