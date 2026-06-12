package com.sedena.app.services;

import java.util.List;

import com.sedena.app.entities.User;

public interface IService {
	boolean insert(User u);
	User selectByEmail(String email);
	boolean updateById(User u);
	List<User> selectAll();
	boolean deleteById(long id);
}
