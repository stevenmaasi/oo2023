package ee.steven.eksam;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("archive-post")
    public String archivePost(@RequestBody String instagramUrl) {
        return this.postService.archivePost(instagramUrl);
    }
}
