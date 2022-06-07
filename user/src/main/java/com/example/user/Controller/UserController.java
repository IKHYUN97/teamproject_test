package com.example.user.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.user.dto.User;
import com.example.user.service.UserService;


@Controller
public class UserController {
	////DI/////
	private final UserService userService;
	public  UserController(UserService userService) {
		this.userService = userService;
	}
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	/////총회원조회///////
	@GetMapping("/userList")
	public String getuserList(Model model) {
		List<User> userList = userService.getUserList();
		log.info("조회한모든회원  :  {}", userList);
		model.addAttribute("userList", userList);
		
		return "user/userList";
	}
	/////회원가입/////
	@PostMapping("/userInsert")
	public String addUserInsert(User user
			,@RequestParam(name="userId",required = false)String userId) {
		log.info("받아온가입정보   :    {}", user);
		log.info("받아온가입아이디  :    {}", userId);
		userService.addUserInsert(user);
		
		//1번안 구매자와 판매자 공통 가입정보 입력 후
		//판매자이면 판매자 추가정보 등록으로 간다
		
		//2번안은 1차 가입 후 리스트가 아니라 확인 하는 화면으로 가서 판매자만 추가 정보 등록으로 가도록 하면 된다.
		
		
		return "redirect:/userList";
	}
	@GetMapping("/userInsert")
	public String addUserInsert(Model model) {
		return "user/userInsert2";
	}
	/////아이디 중복체크/////	
	@PostMapping("/idCheck")
	@ResponseBody
	public boolean idCheck(@RequestParam(name="userId")String userId) {
		log.info("아이디중복체크값  ;  {}", userId);
		boolean isIdCheck = true;
		User user = userService.getUserInfoById(userId);
		if(user != null) {
			isIdCheck = false;
		}
		return isIdCheck;
	}
	////셀러회원가입 겟맵핑
	/*@GetMapping("/addseller")
	public String addInsertSeller() {
		return "user/addseller";
	}
	/////셀러회원진짜가입////
	@PostMapping("/addseller")
	public String addInsertSeller(Model model) {
		
		return "user/addseller";
	}*/
}






































