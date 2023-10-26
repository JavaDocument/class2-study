package level8.domain.repository;

import level8.domain.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository {

    Long save(Post post);

    List<Post> findAll();

    Post findById(Long id);

    Post update(Long id, Post post);
}
