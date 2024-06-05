package com.test.shorturl.dto;

import lombok.Data;

@Data
public class GetShortUrlResponse {
    private String statusCode;
    private String codeMessage;
    private String shortUrl;
}
