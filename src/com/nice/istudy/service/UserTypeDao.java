package com.nice.istudy.service;


import java.util.List;


import com.nice.istudy.entity.UserType;

public interface UserTypeDao {
	
	public boolean addUserType(UserType userType);
	
	public boolean deleteUserType(int id);
	
	public boolean updateUserType(UserType userType);
	
	public List<UserType> selectAllUserType();
	
	public UserType selectBookTypeById(int id);
	
}
