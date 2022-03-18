package springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot.domain.posts.Posts;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private String date;
    private String difficulty;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author, String date, String difficulty) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.difficulty = difficulty;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .date(date)
                .difficulty(difficulty)
                .build();
    }
}
