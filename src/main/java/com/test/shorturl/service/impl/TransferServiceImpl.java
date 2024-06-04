package com.test.shorturl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.test.shorturl.dto.UrlRequest;
import com.test.shorturl.dto.UrlResponse;
import com.test.shorturl.service.RedisService;
import com.test.shorturl.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private RedisService redisService;

    @Override
    public UrlResponse getShortUrl(UrlRequest request) {
        UrlResponse response = new UrlResponse();
        String shorturl = DigestUtils.md5DigestAsHex(request.getUrl().getBytes());
        response.setCode(shorturl);
        response.setShortUrl("http://localhost:8080/shorturl/" + shorturl);
        // 目前Redis設一分鐘過期
        redisService.setWithExpiration(response.getCode(), request.getUrl(), 1);
        return response;
    }

    @Override
    public String goUrl(String code) {
        String url = redisService.getValue(code).toString();
        String html = String.format("<html><meta http-equiv='refresh' content='0;url=%s'/></html>", url);
        return html;
    }

}
