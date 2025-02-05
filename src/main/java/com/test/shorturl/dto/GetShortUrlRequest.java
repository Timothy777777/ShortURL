package com.test.shorturl.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GetShortUrlRequest {

    private String testType;

    private String url;

    @NotNull(message = "expireTime 不能為空")
    @NotEmpty(message = "expireTime 不能為空字串")
    private String expireTime;

    @AssertTrue(message = "當 type 為 2 或 3 時，url 不能為空")
    private boolean isApppppValid() {
        return !("2".equals(testType) || "3".equals(testType)) || (url != null && !url.isEmpty());
    }
}
