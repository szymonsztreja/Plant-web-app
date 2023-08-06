package com.plant.plant_backend.services;

import com.plant.plant_backend.data.dao.PostDao;
import com.plant.plant_backend.data.dtos.PostDto;
import com.plant.plant_backend.data.dtos.PostDTOMapper;
import com.plant.plant_backend.data.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostDao postDao;
    private final PostDTOMapper postDTOMapper;

    public PostService(PostDao postDao, PostDTOMapper postDTOMapper) {
        this.postDao = postDao;
        this.postDTOMapper = postDTOMapper;
    }

    public PostDto findPostById(Long id){
        return postDTOMapper
                .map(postDao.findPostById(id)
                        .orElseThrow());
    }

    public List<PostDto> findPostsByPlantId(Long id){
        return postDao.findPostsByPlantId(id)
                .stream()
                .map(postDTOMapper::map)
                .collect(Collectors.toList());
    }

    public List<PostDto> findAllPosts(){
        return postDao.findAllPosts()
                .stream()
                .map(postDTOMapper::map)
                .collect(Collectors.toList());
    }

    public void save(PostDto postDto){
        Post post = postDTOMapper.mapToEntity(postDto);
        postDao.save(post);
    }
}
