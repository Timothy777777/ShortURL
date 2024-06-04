package com.test.shorturl.service;

public interface RedisService {
    void setValue(String key, String value);

    Object getValue(String key);

    void setWithExpiration(String key, String value, long expirationMinutes);

}
