package com.lcomputerstudy.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lcomputerstudy.fileupload.service.UserService;
import com.lcomputerstudy.fileupload.vo.User;

@Controller
public class UploadController {
	
	@Autowired UserService userservice;
	
	@RequestMapping("/uploadForm")
	public String form() {
		return "/upload";
	}
	
	@RequestMapping(value="upload", method=RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile multipartFile) {
		File file = new File("/Users/lcomputer/Documents/workspace/fileupload/src/main/resources/static/images/" + multipartFile.getOriginalFilename());
		try {
			InputStream input = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(input, file);
		} catch (IOException e) {
			FileUtils.deleteQuietly(file);
			e.printStackTrace();
		}
		return "/printImage";
	}
	
	@RequestMapping("/")
	public String home() {
		return "/index";
	}
	
	@RequestMapping("/beforeSignup") 
	public String beforeSignup(Model model) {
		return "/signup";
	}
	
	@RequestMapping("/signup")
	public String signup(User user) {
		//비밀번호 암호화
		String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
  
		//유저 데이터 세팅
		user.setPassword(encodedPassword);
		user.setAccountNonExpired(true);
		user.setEnabled(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));   
		  
		//유저 생성
		userservice.createUser(user);
		//유저 권한 생성
		userservice.createAuthorities(user);
		  
		return "/login";
   }
	
	@RequestMapping(value="/login")
	public String beforeLogin(Model model) {
		return "/login";
	}
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value="/admin")
	public String admin(Model model) {
		return "/admin";
	}
	   
	@Secured({"ROLE_USER"})
	@RequestMapping(value="/user/info")
	public String userInfo(Model model) {
	      
		return "/user_info";
	}
	   
	@RequestMapping(value="/denied")
	public String denied(Model model) {
		return "/denied";
	}
	
}
