package com.test.shorturl.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.test.shorturl.dto.GetShortUrlRequest;
import com.test.shorturl.dto.GetShortUrlResponse;
import com.test.shorturl.service.RedisService;
import com.test.shorturl.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {

    private Logger logger = LoggerFactory.getLogger(TransferServiceImpl.class);

    @Autowired
    private RedisService redisService;

    @Override
    public GetShortUrlResponse getShortUrl(GetShortUrlRequest request) {
        GetShortUrlResponse response = new GetShortUrlResponse();
        String shorturl = DigestUtils.md5DigestAsHex(request.getUrl().getBytes());
        long expireTime = Integer.valueOf(request.getExpireTime());
        try {
            response.setStatusCode("0");
            response.setCodeMessage(shorturl);
            response.setShortUrl("http://localhost:8080/shorturl/" + shorturl);
            // Redis過期時間自定
            redisService.setWithExpiration(response.getCodeMessage(), request.getUrl(), expireTime);
            return response;
        } catch (Exception e) {
            logger.error(e.getMessage());
            response.setStatusCode("0X");
            response.setCodeMessage(e.getMessage());
            response.setShortUrl("");
            return response;
        }
    }

    @Override
    public String toRealUrl(String code) {
        Object url = redisService.getValue(code);
        if (url != null) {
            String html = String.format("<html><meta http-equiv='refresh' content='0;url=%s'/></html>", url.toString());
            return html;
        } else {
            return "null";
        }
    }

}
