package com.bringko.wordfrequency.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WordFrequencyService {

    /**
     * 주어진 URL에서 HTML을 가져와 텍스트를 추출한 후 단어 빈도수를 계산하는 메서드
     *
     * @param url 분석할 웹 페이지의 URL
     * @return 단어 빈도수를 계산한 Map
     * @throws IOException URL에 접근할 수 없을 때 발생하는 예외
     */
    public Map<String, Long> getWordFrequencies(String url) throws IOException {
        // URL에서 HTML 가져오기
        String htmlContent = fetchHtmlFromUrl(url);

        // HTML에서 텍스트 추출 (정규식을 사용하여 HTML 태그 제거)
        String text = htmlContent.replaceAll("<[^>]*>", " ");

        // 텍스트를 공백을 기준으로 단어로 분리하고 빈도수 계산
        return Arrays.stream(text.toLowerCase().split("\\s+"))
                .filter(word -> word.matches("[a-zA-Z가-힣]+"))  // 한글과 영어 단어만 남기기
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    /**
     * 주어진 URL에서 HTML을 가져오는 메서드
     *
     * @param url 웹 페이지의 URL
     * @return HTML 콘텐츠
     * @throws IOException URL에 접근할 수 없을 때 발생하는 예외
     */
    private String fetchHtmlFromUrl(String url) throws IOException {
        // HttpURLConnection을 사용하여 웹 페이지 요청
        URL website = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) website.openConnection();
        connection.setRequestMethod("GET");

        // 응답 데이터를 읽기
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        // 연결 종료
        in.close();
        connection.disconnect();

        // HTML 콘텐츠 반환
        return content.toString();
    }
}
