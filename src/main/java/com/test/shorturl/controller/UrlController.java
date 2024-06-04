package com.test.shorturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.shorturl.dto.UrlRequest;
import com.test.shorturl.dto.UrlResponse;
import com.test.shorturl.service.TransferService;

import io.swagger.v3.oas.annotations.Operation;

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
    public ResponseEntity<UrlResponse> getShortUrl(@RequestBody UrlRequest request) {
        UrlResponse response = transferService.getShortUrl(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "{code}")
    public ResponseEntity<String> goUrl(@PathVariable String code) {
        String responseUrl = transferService.goUrl(code);
        return ResponseEntity.ok(responseUrl);
    }

}
