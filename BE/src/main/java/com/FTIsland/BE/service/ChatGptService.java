package com.FTIsland.BE.service;


import com.FTIsland.BE.ChatGptConfig;
import com.FTIsland.BE.ChatGptMessage;
import com.FTIsland.BE.dto.ChatGptRequest;
import com.FTIsland.BE.dto.ChatGptResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatGptService {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${api-key.chat-gpt}")
    private String apiKey;

    public HttpEntity<ChatGptRequest> buildHttpEntity(ChatGptRequest chatGptRequest){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.parseMediaType(ChatGptConfig.MEDIA_TYPE));
        httpHeaders.add(ChatGptConfig.AUTHORIZATION, ChatGptConfig.BEARER + apiKey);
        return new HttpEntity<>(chatGptRequest, httpHeaders);
    }

    public ChatGptResponse getResponse(HttpEntity<ChatGptRequest> chatGptRequestHttpEntity){

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(60000);
        //답변이 길어질 경우 TimeOut Error가 발생하니 1분정도 설정해줍니다.
        requestFactory.setReadTimeout(60 * 1000);   //  1min = 60 sec * 1,000ms
        restTemplate.setRequestFactory(requestFactory);

        ResponseEntity<ChatGptResponse> responseEntity = restTemplate.postForEntity(
                ChatGptConfig.CHAT_URL,
                chatGptRequestHttpEntity,
                ChatGptResponse.class);

        return responseEntity.getBody();
    }
    public ChatGptResponse askQuestion(String bookTitle, Integer userLevel){

        String finalQuestion = bookTitle + " 동화를 읽은 " + userLevel + "세 아이에게 정답이 없는 생각해볼만한 질문을 3개만 해줘.";

        List<ChatGptMessage> messages = new ArrayList<>();
        messages.add(ChatGptMessage.builder()
                .role(ChatGptConfig.USER)
                .content("아기 돼지 삼형제 동화를 읽은 " + userLevel + "세 아이에게 할 수 있는 정답이 없는 생각해볼만한 질문을 3개만 해줘.")
                .build());
        messages.add(ChatGptMessage.builder()
                .role(ChatGptConfig.ASSISTANT)
                .content("1. 만약에 네가 돼지라면, 너는 어떤 재료로 집을 지을 거야? 왜 그 재료를 선택했을까?\n" +
                        "2. 세 번째 돼지처럼 너도 집을 지을 때, 어떤 비밀 장치를 집어넣을 거야? 그 이유는 뭐야?\n" +
                        "3. 만약에 이야기의 끝이 달라져서, 돼지 삼형제가 늑대와 친구가 될 수 있다면, 어떤 모험이 벌어질 것 같아?")
                .build());
        messages.add(ChatGptMessage.builder()
                .role(ChatGptConfig.SYSTEM)
                .content("assistant는 다정하고 친절한 엄마야")
                .build());
        messages.add(ChatGptMessage.builder()
                .role(ChatGptConfig.ROLE)
//                .content(questionRequest.getQuestion())
                .content(finalQuestion)
                .build());
        return this.getResponse(
                this.buildHttpEntity(
                        new ChatGptRequest(
                                ChatGptConfig.CHAT_MODEL,
                                ChatGptConfig.MAX_TOKEN,
                                ChatGptConfig.TEMPERATURE,
                                ChatGptConfig.STREAM,
                                messages
                                //ChatGptConfig.TOP_P
                        )
                )
        );
    }

}