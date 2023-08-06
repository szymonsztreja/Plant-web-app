package com.plant.plant_backend.data.dtos;

import com.plant.plant_backend.data.model.Plant;
import com.plant.plant_backend.data.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostDTOMapper implements IMapEntities<PostDto, Post>{
    @Override
    public PostDto map(Post post) {
        return new PostDto(
                post.getId(),
                post.getAuthor(),
                post.getPlant(),
                post.getTitle(),
                post.getContent()
        );
    }

    @Override
    public Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setAuthor(postDto.getAuthor());
        post.setPlant(postDto.getPlant());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        return post;
    }

}

