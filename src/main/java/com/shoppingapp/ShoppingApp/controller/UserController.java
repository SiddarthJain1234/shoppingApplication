package com.shoppingapp.ShoppingApp.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapp.ShoppingApp.Service.UserService;
import com.shoppingapp.ShoppingApp.dto.request.SigninDto;
import com.shoppingapp.ShoppingApp.dto.request.SignupDto;
import com.shoppingapp.ShoppingApp.dto.response.ResponseDto;
import com.shoppingapp.ShoppingApp.model.UserEntity;
import com.shoppingapp.ShoppingApp.repository.UserRepo;

@RequestMapping("/User")
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	
	@PostMapping("/signup")
	public ResponseDto signup(@RequestBody SignupDto signupDto) {
	   return userService.createUser(signupDto);
	}
	
	@PostMapping("/signin")
	public ResponseDto signin(@RequestBody SigninDto signinDto) throws NoSuchAlgorithmException {
		return userService.signin(signinDto);
	}
	
	
	@RequestMapping("/logout")
	public ResponseDto logout(@RequestParam("email") String email) {
	return	userService.logout(email);
		
	}
	
	
	
	
}
