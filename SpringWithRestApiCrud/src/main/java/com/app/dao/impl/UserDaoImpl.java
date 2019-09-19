package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao{
	@Autowired
	private HibernateTemplate template;

	public Integer saveUser(User user) {
		Integer userId=(Integer) template.save(user);
		return userId;
	}

	public User findUserById(Integer id) {
		User user=template.get(User.class, id);
		return user;
	}

	public List<User> findAllUser() {
		return template.loadAll(User.class);
	}

	public void updateUser(User user) {
		template.update(user);
		
	}
	public void deleteUser(User userId) {
		template.delete(userId);
	}
	

}
