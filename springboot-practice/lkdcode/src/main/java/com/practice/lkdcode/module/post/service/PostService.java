package com.practice.lkdcode.module.post.service;

import com.practice.lkdcode.module.post.controller.dto.request.PostRequestDTO;
import com.practice.lkdcode.module.post.controller.dto.response.PostResponseDTO;
import com.practice.lkdcode.module.post.domain.Post;
import com.practice.lkdcode.module.post.domain.repository.PostRepository;
import com.practice.lkdcode.module.post.service.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostResponseDTO.Get loadFindById(final Long id) {
        Post post = getPost(id);
        return PostMapper.toResponseGetFromPost(post);
    }

    public List<PostResponseDTO.Get> loadFindAll() {
        List<Post> list = postRepository.findAll();
        return PostMapper.toResponseGetAllFromPostList(list);
    }

    public PostResponseDTO.Create loadSave(final PostRequestDTO.Create request) {
        Post post = PostMapper.toPostFromRequestCreate(request);
        Post saved = postRepository.save(post);

        return PostMapper.toResponseCreateFromPost(saved);
    }

    public PostResponseDTO.Update loadUpdate(final Long id, final PostRequestDTO.Update request) {
        Post post = getPost(id);
        post.update(request.title(), request.content());
        postRepository.save(post);
        return PostMapper.toResponseUpdateFromPost(post);
    }

    public PostResponseDTO.Delete loadDelete(final Long id) {
        Post post = getPost(id);

        postRepository.deleteById(id);
        return PostMapper.toResponseDeleteFromPost(post);
    }

    private Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("존재하지 않는 게시글 번호 입니다. [id : " + id + "]"));
    }

}
