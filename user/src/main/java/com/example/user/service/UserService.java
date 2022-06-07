package com.example.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.user.Mapper.UserMapper;
import com.example.user.dto.User;

@Service
@Transactional
public class UserService {
  
	private final UserMapper userMapper;
	public  UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	//회원목록조회
	public List<User> getUserList() {
		
		List<User> userList = userMapper.getUserList();
		
		return userList;
	}
	//회원가입인설트/////
	public int addUserInsert(User user) {
	 
		int result = userMapper.addUserInsert(user);
	   
		return result;
	}
	/////회원가입 중복체크/////로직
	public User getUserInfoById(String userId) {
		
		User user = userMapper.getUserInfoById(userId);
		
		return user;
	}
}
