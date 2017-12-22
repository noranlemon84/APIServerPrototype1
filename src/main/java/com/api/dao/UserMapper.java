package com.api.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface UserMapper {
	
	public int checkId(@Param("user_id")String user_id) throws Exception;
	
	public int insertId(@Param("user_id")String user_id, @Param("user_name")String user_name, @Param("user_addr")String user_addr) throws Exception;
	
	
}
