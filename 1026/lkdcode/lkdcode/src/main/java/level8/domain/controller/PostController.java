package level8.domain.controller;

import jakarta.validation.Valid;
import level8.domain.controller.common.PostResponse;
import level8.domain.dto.PostDTO;
import level8.domain.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public PostResponse<List<PostDTO.Response>> getAllPosts() {
        List<PostDTO.Response> response = postService.loadFindAll();
        return PostResponse.ok(response);
    }

    @PostMapping
    public PostResponse<PostDTO.CreateResponse> createPost(@RequestBody @Valid final PostDTO.CreateRequest request) {
        PostDTO.CreateResponse createResponse = postService.loadSave(request);
        return PostResponse.ok(createResponse);
    }

    @PatchMapping("/{id}")
    public PostResponse<PostDTO.UpdateResponse> updatePost(
            @PathVariable(name = "id") Long id,
            @RequestBody @Valid PostDTO.UpdateRequest request
    ) {
        PostDTO.UpdateResponse updateResponse = postService.loadUpdatePost(id, request);
        return PostResponse.ok(updateResponse);
    }

}
