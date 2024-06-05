package com.test.shorturl.service;

import com.test.shorturl.dto.GetShortUrlRequest;
import com.test.shorturl.dto.GetShortUrlResponse;

public interface TransferService {

    GetShortUrlResponse getShortUrl(GetShortUrlRequest request);

    String toRealUrl(String code);
}
