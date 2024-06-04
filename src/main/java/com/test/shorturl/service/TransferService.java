package com.test.shorturl.service;

import com.test.shorturl.dto.UrlRequest;
import com.test.shorturl.dto.UrlResponse;

public interface TransferService {

    UrlResponse getShortUrl(UrlRequest request);

    String goUrl(String code);
}
