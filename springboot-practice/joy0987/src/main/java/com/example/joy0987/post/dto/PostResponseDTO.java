package com.example.joy0987.post.dto;

import lombok.Builder;

@Builder
public record PostResponseDTO (
     int id,
     String title,
     String content
) {


};

