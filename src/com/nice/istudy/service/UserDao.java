package com.nice.istudy.service;

import java.util.List;

import com.nice.istudy.entity.User;

public interface UserDao {
	public boolean userLogin(User u);

	public boolean loginByStudentNoAndPassword(User user);

	public boolean addUser(User user);

	public boolean deleteUser(int id);

	public boolean updateUser(User user);

	public List<User> selectAllUsers();

	public User selectUserById(int id);

	public User selectUserByStudentNo(String studentNo);
}
