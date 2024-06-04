package com.test.shorturl.dto;

import lombok.Data;

@Data
public class UrlResponse {
    private String code;
    private String shortUrl;
}
