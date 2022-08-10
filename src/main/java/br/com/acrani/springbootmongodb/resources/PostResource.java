package br.com.acrani.springbootmongodb.resources;

import br.com.acrani.springbootmongodb.models.Post;
import br.com.acrani.springbootmongodb.resources.utils.URL;
import br.com.acrani.springbootmongodb.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findbyTitleContaining(@RequestParam(value = "text", defaultValue = "") String text){
        List<Post> posts = postService.findByTitleContaining(URL.decodeParam(text));
        return ResponseEntity.ok().body(posts);
    }

}
