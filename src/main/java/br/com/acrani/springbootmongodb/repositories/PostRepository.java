package br.com.acrani.springbootmongodb.repositories;

import br.com.acrani.springbootmongodb.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
