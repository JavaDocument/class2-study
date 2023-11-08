package com.practice.jefeel.post.service;


import com.practice.jefeel.post.controller.dto.PostResponseDTO;
import com.practice.jefeel.post.controller.dto.PostUpdateRequestDTO;
import com.practice.jefeel.post.domain.entity.Post;
import com.practice.jefeel.post.domain.repository.PostRepository;
import com.practice.jefeel.post.controller.dto.PostSaveRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository repository;

    @Transactional
    public Long save(PostSaveRequestDTO requestDTO) {
        return repository.save(requestDTO.toEntity()).getId();
    }

    public PostResponseDTO findById(Long id) {
        Post entity = repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시물이 존재하지 않습니다. id = " + id));
        return new PostResponseDTO(entity);
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDTO requestDTO) {
        Post post = repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시물이 존재하지 않습니다. id = " + id));

        post.update(requestDTO.getTitle(), requestDTO.getContent());

        return id;

    }
}
