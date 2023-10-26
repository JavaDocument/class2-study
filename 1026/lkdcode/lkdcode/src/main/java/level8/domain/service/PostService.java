package level8.domain.service;

import level8.domain.dto.PostDTO;
import level8.domain.entity.Post;
import level8.domain.mapper.PostMapper;
import level8.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private Long id = 1L;

    public PostDTO.CreateResponse loadSave(final PostDTO.CreateRequest request) {
        Post post = postMapper.getPostFromCreateRequest(request, id++, now());
        Long savedId = postRepository.save(post);
        return postMapper.getCreateResponseFromPostId(savedId);
    }

    public List<PostDTO.Response> loadFindAll() {
        List<Post> list = postRepository.findAll();

        return list.stream()
                .map(postMapper::getResponseFromPost)
                .collect(Collectors.toList());
    }

    public PostDTO.UpdateResponse loadUpdatePost(final Long id, PostDTO.UpdateRequest request) {
        Post post = postRepository.findById(id);
        if (post == null) {
            throw new NullPointerException("게시글 ID가 존재하지 않습니다.");
        }

        LocalDateTime createDate = post.getCreateDate();

        Post updatedPost = postMapper.getPostFromUpdateRequest(request, createDate, now(), post);
        Post updated = postRepository.update(id, updatedPost);

        return postMapper.getUpdateResponseFromPost(updated);
    }

}
