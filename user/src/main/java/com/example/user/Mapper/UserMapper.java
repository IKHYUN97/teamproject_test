package com.example.user.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.user.dto.User;

@Mapper
public interface UserMapper {
	///회원정보출력/// 성공/.../	
	public List<User> getUserList();
	
	////회원가입/////
	public int addUserInsert(User user);
	
	////회원아이디체크/////
	public User getUserInfoById(String userId);
}
