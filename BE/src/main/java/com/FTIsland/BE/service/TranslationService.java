package com.FTIsland.BE.service;

import com.FTIsland.BE.dto.BookContentDTO;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TranslationService {
    @Value("${google.translation.api-key}")
    private String apiKey;
    public String test(String selectedLanguage, String text) {

        Translate translate = TranslateOptions.newBuilder().setApiKey(apiKey).build().getService(); // Translate 클라이언트를 빌드

        String sourceLanguage = "ko"; // 한국어
        String targetLanguage = selectedLanguage;

        Translation translation = translate.translate(text, Translate.TranslateOption.sourceLanguage(sourceLanguage),
                Translate.TranslateOption.targetLanguage(targetLanguage)); // 번역 실행

        // System.out.println("원본: " + text);
        // System.out.println("번역: " + translation.getTranslatedText());

        return translation.getTranslatedText();
    }
}
