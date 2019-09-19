package com.app.service;

import java.util.List;

import com.app.model.User;

public interface IUserService {
	
	public Integer saveUser(User user);
	public User findUserById(Integer id);
	public List<User> findAllUser();
	public void updateUser(User user);
	public void deleteUser(User user);

}
