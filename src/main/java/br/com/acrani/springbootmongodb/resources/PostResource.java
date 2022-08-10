package br.com.acrani.springbootmongodb.resources;

import br.com.acrani.springbootmongodb.models.Post;
import br.com.acrani.springbootmongodb.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostResource {

    private final PostService postService;

    public PostResource(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findbyId(@PathVariable String id){
        Post byId = postService.findById(id);
        return ResponseEntity.ok().body(byId);
    }

}
