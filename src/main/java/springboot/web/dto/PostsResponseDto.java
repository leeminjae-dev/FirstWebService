package springboot.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import springboot.domain.posts.Posts;

import java.time.LocalDateTime;

@Getter
@ToString
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String date;
    private String difficulty;
    private LocalDateTime createdDate;

    @Builder
    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.date = entity.getDate();
        this.difficulty = entity.getDifficulty();
        this.createdDate = entity.getCreatedDate();
    }
}
