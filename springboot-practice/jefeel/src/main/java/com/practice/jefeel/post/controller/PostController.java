package com.practice.jefeel.post.controller;


import com.practice.jefeel.post.controller.dto.PostResponseDTO;
import com.practice.jefeel.post.controller.dto.PostSaveRequestDTO;
import com.practice.jefeel.post.controller.dto.PostUpdateRequestDTO;
import com.practice.jefeel.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService service;

    // create
    @PostMapping()
    public Long save(
            @RequestBody PostSaveRequestDTO dto
    ){
        return service.save(dto);
    }

    // read
    @GetMapping("/{id}")
    public PostResponseDTO findById(
            @PathVariable Long id
    ){
        return service.findById(id);
    }
    // update
    @PutMapping("/{id}")
    public Long update(
            @PathVariable Long id,
            @RequestBody PostUpdateRequestDTO requestDTO
    ){
        return service.update(id, requestDTO);
    }
    // delete


}
