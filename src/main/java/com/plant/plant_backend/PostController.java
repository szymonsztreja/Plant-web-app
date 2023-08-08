package com.plant.plant_backend;

import com.plant.plant_backend.data.dtos.PostDto;
import com.plant.plant_backend.data.model.Post;
import com.plant.plant_backend.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post/")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
            return ResponseEntity.ok(postService.findPostById(id));
    }

    @GetMapping("{plantId}")
    public ResponseEntity<List<PostDto>> getAllPostsByPlantId(@PathVariable Long id){
        return ResponseEntity.ok(postService.findPostsByPlantId(id));
    }

    @GetMapping()
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return ResponseEntity.ok(postService.findAllPosts());
    }

    @PostMapping("{plantId}")
    public ResponseEntity<PostDto> savePost(@RequestBody PostDto postDto) {
        postService.save(postDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
