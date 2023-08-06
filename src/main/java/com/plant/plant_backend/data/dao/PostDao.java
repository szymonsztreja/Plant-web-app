package com.plant.plant_backend.data.dao;

import com.plant.plant_backend.data.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostDao {

    Optional<Post> findPostById(Long id);
    List<Post> findPostsByPlantId(Long id);
    List<Post> findAllPosts();
    void save(Post post);
    void updatePostById(Post postUpdate);
    void delete(Long id);
    boolean existsPostWithId(Long id);


}
