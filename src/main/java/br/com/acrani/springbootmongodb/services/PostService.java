package br.com.acrani.springbootmongodb.services;

import br.com.acrani.springbootmongodb.models.Post;
import br.com.acrani.springbootmongodb.repositories.PostRepository;
import br.com.acrani.springbootmongodb.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id){
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post não encontrado. Id:" + id));
    }

}
