package level8.domain.repository;

import level8.domain.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepositoryMap implements PostRepository {
    private final Map<Long, Post> map = new HashMap<>();

    @Override
    public Long save(final Post post) {
        Long id = post.getId();
        map.put(post.getId(), post);
        return id;
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Post findById(final Long id) {
        return map.get(id);
    }

    @Override
    public Post update(final Long id, final Post post) {
        if (findById(id) == null) throw new NullPointerException();
        map.put(id, post);
        return findById(id);
    }

}
