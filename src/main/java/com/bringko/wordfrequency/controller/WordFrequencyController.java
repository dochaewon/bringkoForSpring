package com.bringko.wordfrequency.controller;

import com.bringko.wordfrequency.service.WordFrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class WordFrequencyController {

    @Autowired
    private WordFrequencyService wordFrequencyService;

    /**
     * 주어진 URL에서 단어 빈도수를 분석하는 API 엔드포인트
     *
     * @param url 분석할 웹 페이지의 URL
     * @return 단어 빈도수 결과를 포함한 JSON 응답
     */
    @GetMapping("/api/parse")
    public ResponseEntity<Map<String, Long>> parse(@RequestParam String url) {
        try {
            // WordFrequencyService를 통해 단어 빈도수 분석
            Map<String, Long> wordFrequencies = wordFrequencyService.getWordFrequencies(url);
            return ResponseEntity.ok(wordFrequencies);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);  // URL 접근 실패 시 500 에러 반환
        }
    }
}
