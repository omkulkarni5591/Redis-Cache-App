package com.oksoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.oksoft.model.User;

@SpringBootApplication
public class Application {

	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory=new JedisConnectionFactory();
		
		
		return jedisConnectionFactory;
	}
	
    @Bean
	RedisTemplate<String,User> redisTemplate(){
		
		RedisTemplate<String,User> redisTemplate=new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
    
    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
