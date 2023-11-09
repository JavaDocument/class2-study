package com.practice.jefeel.module.post.service;


import com.practice.jefeel.module.post.controller.dto.PostResponseDTO;
import com.practice.jefeel.module.post.controller.dto.PostSaveRequestDTO;
import com.practice.jefeel.module.post.controller.dto.PostUpdateRequestDTO;
import com.practice.jefeel.module.post.domain.Post;
import com.practice.jefeel.module.post.domain.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository repository;

    @Transactional
    public Long save(PostSaveRequestDTO requestDTO) {
        return repository.save(requestDTO.toEntity()).getId();
    }

    public PostResponseDTO findById(Long id) {
        Post entity = getPost(id);

        return new PostResponseDTO(entity);
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDTO requestDTO) {
        Post post = getPost(id);

        post.update(requestDTO.getTitle(), requestDTO.getContent());

        return id;

    } //PostDetailResponseDTO 반환

    @Transactional
    public void delete(Long id){
        Post post = getPost(id);

        repository.delete(post);
    }

    private Post getPost(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시물이 존재하지 않습니다. id = " + id));
    }

    //exceptionhandler
}
