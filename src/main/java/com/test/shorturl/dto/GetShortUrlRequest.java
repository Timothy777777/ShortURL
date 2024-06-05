package com.test.shorturl.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GetShortUrlRequest {
    @NotNull
    private String url;
    @NotNull
    private String expireTime;
}
