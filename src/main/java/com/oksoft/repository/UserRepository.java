package com.oksoft.repository;

import java.util.Map;

import com.oksoft.model.User;

public interface UserRepository {

	void save(User user);
	
	Map<String, User> findAll();
	
	User findById(Integer integer);
	
	void update(User user);
	
	void delete(String userId);
}
