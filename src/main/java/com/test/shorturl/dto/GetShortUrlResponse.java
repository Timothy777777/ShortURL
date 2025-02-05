package com.test.shorturl.dto;

import lombok.Data;

@Data
public class GetShortUrlResponse {
    private String statusCode;
    private String codeMessage;
    private String shortUrl;

    public GetShortUrlResponse(String statusCode, String codeMessage, String shortUrl) {
        this.statusCode = statusCode;
        this.codeMessage = codeMessage;
        this.shortUrl = shortUrl;
    }
}
