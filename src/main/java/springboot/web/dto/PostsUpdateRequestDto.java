package springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot.domain.posts.Posts;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;
    private String date;
    private String difficulty;

    @Builder
    public PostsUpdateRequestDto(String title, String content, String date, String difficulty) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.difficulty = difficulty;
    }
}
