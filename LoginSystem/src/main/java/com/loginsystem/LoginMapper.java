package com.loginsystem;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
	List<Login> selectAll();
}
