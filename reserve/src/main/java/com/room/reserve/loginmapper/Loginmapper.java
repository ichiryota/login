package com.room.reserve.loginmapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.room.reserve.login.Login;

@Mapper
public interface Loginmapper {
	public  List<Login> selectAll(Login login);
}
