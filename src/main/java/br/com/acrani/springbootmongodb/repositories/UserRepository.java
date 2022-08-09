package br.com.acrani.springbootmongodb.repositories;

import br.com.acrani.springbootmongodb.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
