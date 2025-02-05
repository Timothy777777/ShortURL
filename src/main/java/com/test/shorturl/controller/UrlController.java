package com.test.shorturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.shorturl.dto.GetShortUrlRequest;
import com.test.shorturl.dto.GetShortUrlResponse;
import com.test.shorturl.service.TransferService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("shorturl")
public class UrlController {

    @Autowired
    private TransferService transferService;

    @Operation(summary = "測試用", description = "回傳hello")
    @GetMapping(value = "/test")
    public String hi() {
        return "<html><meta http-equiv='refresh' content='0;url=https://www.instagram.com/?hl=zh-tw'/></html>";
    }

    @PostMapping(value = "/getShortUrl")
    public ResponseEntity<GetShortUrlResponse> getShortUrl(@RequestBody @Valid GetShortUrlRequest request) {
        GetShortUrlResponse response = transferService.getShortUrl(request);
        if (response.getStatusCode().equals("0")) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @GetMapping(value = "{code}")
    public ResponseEntity<String> toRealUrl(@PathVariable String code) {
        String responseUrl = transferService.toRealUrl(code);
        if (!responseUrl.equals("null")) {
            return ResponseEntity.ok(responseUrl);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
