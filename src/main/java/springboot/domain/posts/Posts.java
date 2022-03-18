package springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    private String date;

    private String difficulty;

    @Builder
    public Posts(String title, String content, String author, String date, String difficulty) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.date = date;
        this.difficulty = difficulty;
    }

    public void update(String title, String content, String date, String difficulty) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.difficulty = difficulty;
    }
}
