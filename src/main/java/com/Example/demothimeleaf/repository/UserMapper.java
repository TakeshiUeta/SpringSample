package com.Example.demothimeleaf.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.Example.demothimeleaf.domain.user.model.MUser;

@Mapper
public interface UserMapper {
	/**ユーザー登録*/
	public int insertOne(MUser User);
	/**ユーザー取得*/
	public List<MUser> findMany(MUser user); 
	/**ユーザー1件表示*/
	public MUser findOne(String userId);
	/**ユーザー更新*/
	public void updateOne(
			@Param("userId")String userId,
			@Param("password")String password,
			@Param("userName")String userName);
	/*ユーザー更新でMUserを引数とした場合
	 * public void updateOne(@Param("user")MUser user);
	 * ※userがパラメータ。xml参照
	 */
	
	/**ユーザー削除*/
	public int deleteOne(@Param("userId")String userId);
}
