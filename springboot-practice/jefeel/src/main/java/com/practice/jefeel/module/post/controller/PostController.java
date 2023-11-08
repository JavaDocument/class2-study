package com.practice.jefeel.module.post.controller;


import com.practice.jefeel.module.post.controller.dto.PostResponseDTO;
import com.practice.jefeel.module.post.controller.dto.PostSaveRequestDTO;
import com.practice.jefeel.module.post.controller.dto.PostUpdateRequestDTO;
import com.practice.jefeel.module.post.service.PostService;
import jakarta.validation.Valid;
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
            @Valid @RequestBody PostSaveRequestDTO dto
    ) {
        return service.save(dto);
    }
    // ResponseEntity<?>


    // read
    @GetMapping("/{id}")
    public PostResponseDTO findById(
            @PathVariable Long id
    ) {
        return service.findById(id);
    }

    // update
    @PutMapping("/{id}")
    public Long update(
            @PathVariable(name = "id") Long id,
            @Valid @RequestBody PostUpdateRequestDTO requestDTO
    ) {
        return service.update(id, requestDTO);
    }
    // pathvariable 명시할것

    // delete
    @DeleteMapping("/{id}")
    public Long delete(
            @PathVariable(name = "id") Long id
    ){
        service.delete(id);
        return id;
    }
}
