package com.FTIsland.BE.bookContent;

import com.FTIsland.BE.book.content.dto.BookContentRequest;
import com.FTIsland.BE.book.content.dto.BookContentResponse;
import com.FTIsland.BE.book.content.service.BookContentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookContentServiceTest {
    @Autowired
    private BookContentService bookContentService;

    @Test
    @DisplayName("책 내용 리스트 반환 동작 테스트")
    // 있는 책 요청 했을 때
    public void getBookContent() throws Exception{
        // given
        BookContentRequest bookContentRequest = new BookContentRequest().builder()
                .bookId(1)
                .mainLan("ko")
                .subLan("en")
                .build();

        // when
        List<BookContentResponse> bookContentResponse = bookContentService.findByBookId(bookContentRequest);

        // then
        assertThat(bookContentResponse).isNotEmpty();   // TODO: DB에 저장된 값과도 비교

    }

    // 없는 책 요청 했을 때
}
