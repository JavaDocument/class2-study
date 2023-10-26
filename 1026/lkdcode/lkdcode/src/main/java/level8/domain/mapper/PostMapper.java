package level8.domain.mapper;

import level8.domain.dto.PostDTO;
import level8.domain.entity.Post;
import lombok.Builder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PostMapper {

    public Post getPostFromCreateRequest(
            final PostDTO.CreateRequest request,
            final Long id,
            final LocalDateTime createDate) {

        return Post.builder()
                .id(id)
                .createDate(createDate)
                .modifyDate(createDate)
                .subject(request.subject())
                .content(request.content())
                .build();
    }

    public PostDTO.CreateResponse getCreateResponseFromPostId(final Long id) {
        return new PostDTO.CreateResponse(id);
    }

    public PostDTO.Response getResponseFromPost(final Post post) {
        return PostDTO.Response.builder()
                .id(post.getId())
                .createDate(post.getCreateDate())
                .modifyDate(post.getModifyDate())
                .subject(post.getSubject())
                .content(post.getContent())
                .build();
    }

    public PostDTO.UpdateResponse getUpdateResponseFromPost(final Post post) {
        return new PostDTO.UpdateResponse(post.getId());
    }

    public Post getPostFromUpdateRequest(
            final PostDTO.UpdateRequest request,
            final LocalDateTime createDate,
            final LocalDateTime modifyDate,
            final Post post) {
        return Post.builder()
                .id(post.getId())
                .createDate(createDate)
                .modifyDate(modifyDate)
                .subject(request.subject())
                .content(request.content())
                .build();
    }

}
