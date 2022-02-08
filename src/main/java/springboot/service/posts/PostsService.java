package springboot.service.posts;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springboot.domain.posts.Posts;
import springboot.domain.posts.PostsRepository;
import springboot.web.dto.PostsListResponseDto;
import springboot.web.dto.PostsResponseDto;
import springboot.web.dto.PostsSaveRequestDto;
import springboot.web.dto.PostsUpdateRequestDto;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public List<PostsResponseDto> findAll() {
        List<Posts> postsList = postsRepository.findAll();
        log.info(postsList.toString());

        List<PostsResponseDto> dtos = new ArrayList<PostsResponseDto>();

        for (Posts posts : postsList) {
            System.out.println(posts);
            dtos.add(new PostsResponseDto(posts));
        }
        log.info(dtos.toString());

        return dtos;
    }

    @Transactional
    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다 id =" +id));
        return new PostsResponseDto(entity);
    }

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());

        entity.update(requestDto.getTitle(), requestDto.getContent());

        return postsRepository.save(entity).getId();
    }

    @Transactional
    public Long delete(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 id의 게시글입니다."));
        postsRepository.deleteById(id);
        return entity.getId();

    }

    @Transactional()
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsListResponseDto :: new)
                .collect(Collectors.toList());
    }
}
