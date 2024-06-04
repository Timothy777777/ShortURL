package com.test.shorturl.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.test.shorturl.service.RedisService;

@Service
public class RedisServiceImpl implements RedisService {

    @SuppressWarnings("rawtypes")
    @Autowired
    private RedisTemplate redisTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public Object getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setWithExpiration(String key, String value, long expirationMinutes) {
        redisTemplate.opsForValue().set(key, value, expirationMinutes, TimeUnit.MINUTES);
    }

}
