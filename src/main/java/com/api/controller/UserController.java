package com.api.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.dao.UserMapper;

@RestController
public class UserController {

	@Autowired
	private UserMapper mapper;
	
	String result_msg = "";

	@RequestMapping(value="/usercheck", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> checkid(HttpServletRequest request) throws Exception {
		
		int cnt = mapper.checkId(request.getParameter("user_id"));
		
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		
		if(cnt==0){
			result_msg = "ID가 없엉  :-(";
		}else{
			result_msg = "존재하는 ID임  :-)";
		}
		
		jsonObject.put("result_msg", result_msg);
		
		
		return jsonObject;
	}
	
	
	
	@RequestMapping(value="/userinsert", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> insertId(HttpServletRequest request) throws Exception {
		
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String user_addr = request.getParameter("user_addr");
		
		
		int cnt = mapper.insertId(user_id, user_name, user_addr);
		
		Map<String, Object> jsonObject = new HashMap<String, Object>();
		
		
		System.out.println("gogogogo [" + cnt + "]");
		
		
		jsonObject.put("result_msg", cnt);
		
		return jsonObject;
		
		
	}
	
	
}
