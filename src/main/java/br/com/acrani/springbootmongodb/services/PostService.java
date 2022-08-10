package br.com.acrani.springbootmongodb.services;

import br.com.acrani.springbootmongodb.models.Post;
import br.com.acrani.springbootmongodb.repositories.PostRepository;
import br.com.acrani.springbootmongodb.resources.utils.URL;
import br.com.acrani.springbootmongodb.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    public List<Post> findByTitleContaining(String text){
        //return postRepository.findByTitleContainingIgnoreCase(text);
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, String minDate, String maxDate){
        Date min = URL.stringToDate(minDate, new Date(0L));
        Date max = URL.stringToDate(maxDate, new Date());
        return postRepository.fullSearch(text, min, max);
    }
}
