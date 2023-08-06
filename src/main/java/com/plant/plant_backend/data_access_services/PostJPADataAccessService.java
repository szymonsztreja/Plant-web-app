package com.plant.plant_backend.data_access_services;

import com.plant.plant_backend.data.dao.PostDao;
import com.plant.plant_backend.data.model.Post;
import com.plant.plant_backend.data.repositories.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostJPADataAccessService implements PostDao {

    private final PostRepository postRepository;

    public PostJPADataAccessService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Optional<Post> findPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> findPostsByPlantId(Long id) {
        return postRepository.findPostsByPlantId(id);
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void updatePostById(Post postUpdate) {
        postRepository.save(postUpdate);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public boolean existsPostWithId(Long id) {
        return postRepository.existsById(id);
    }
}
