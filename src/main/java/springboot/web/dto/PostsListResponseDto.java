package springboot.web.dto;

import lombok.Builder;
import springboot.domain.posts.Posts;

import java.time.LocalDateTime;

public class PostsListResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String date;
    private String difficulty;
    private LocalDateTime modifiedDate;


    @Builder
    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
        this.date = entity.getDate();
        this.difficulty = entity.getDifficulty();
    }
}
