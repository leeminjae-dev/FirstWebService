package springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springboot.config.auth.LoginUser;
import springboot.config.auth.dto.SessionUser;
import springboot.service.posts.PostsService;
import springboot.web.dto.PostsListResponseDto;
import springboot.web.dto.PostsResponseDto;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        List<PostsListResponseDto> postsList = postsService.findAllDesc();
        model.addAttribute("posts", postsList);

        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("picture", user.getPicture());
        }
        return "home";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

    @GetMapping("/posts/{id}")
    public String postsView(@PathVariable Long id, Model model, @LoginUser SessionUser user) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("picture", user.getPicture());
        }
        return "post-view";
    }
}
