package com.lcomputerstudy.fileupload.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;

import com.lcomputerstudy.fileupload.vo.User;

@Mapper
public interface UserMapper {
	//유저읽기
	public User readUser(String username);
	   
	//유저생성
	public void createUser(User user);

	// 권한 읽기
	public List<GrantedAuthority> readAuthorities(String username);

	// 권한 생성	
	public void createAuthority(User user);
}
