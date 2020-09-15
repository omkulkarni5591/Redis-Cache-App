package com.oksoft.repository;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.oksoft.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private RedisTemplate<String,User> redisTemplate;
	
	private HashOperations hashOperations;
	
	public UserRepositoryImpl(RedisTemplate<String,User> redisTemplate) {
		this.redisTemplate=redisTemplate;
		hashOperations=redisTemplate.opsForHash();
	}
	@Override
	public void save(User user) {
     
		hashOperations.put("User",user.getUserId(),user);
	}

	@Override
	public Map<String, User> findAll() {
       return hashOperations.entries("User");
		
	}

	@Override
	public User findById(Integer userId) {
        return (User)hashOperations.get("User", userId);
		
	}

	@Override
	public void update(User user) {

		save(user);
	}

	@Override
	public void delete(String userId) {
		hashOperations.delete("User", userId);
	}

}
