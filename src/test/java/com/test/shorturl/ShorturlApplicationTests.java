package com.test.shorturl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class ShorturlApplicationTests {

	@SuppressWarnings("rawtypes")
	@Autowired
	RedisTemplate redisTemplate;

	@Test
	void contextLoads() {
	}

	@SuppressWarnings("null")
	@Test
	void redisTest() {
		String res = redisTemplate.getConnectionFactory().getConnection().ping();
		Assertions.assertEquals("PONG", res);
		System.out.println(res);
	}

}
