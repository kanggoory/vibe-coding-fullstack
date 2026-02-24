package com.example.vibeapp.post;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Optional;

@Mapper
public interface PostRepository {

    Optional<Post> findById(@Param("no") Long no);

    List<Post> findList(@Param("offset") int offset, @Param("limit") int limit);

    long count();

    void insert(Post post);

    void update(Post post);

    void incrementViews(@Param("no") Long no);

    void deleteById(@Param("no") Long no);

    /**
     * Maintains backward compatibility with the previous in-memory repository's save method.
     * Delegates to insert if 'no' is null, otherwise to update.
     */
    default Post save(Post post) {
        if (post.getNo() == null) {
            insert(post);
        } else {
            update(post);
        }
        return post;
    }
}
