package br.com.acrani.springbootmongodb.repositories;

import br.com.acrani.springbootmongodb.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);

    /**
     * padrão de busca por @Query do MongoDB
     * { <field>: { $regex: /pattern/, $options: '<options>' } }
     * site -> https://www.mongodb.com/docs/manual/reference/operator/query/regex/
     *
     * @param text - texto que compoem o título do post
     * @return - post correspondentes
     */
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    /**
     *
     * @param text - texto que compoem o título, corpo ou comentário do post
     * @param minDate - data mínima para buscar
     * @param maxDate - data máxima para buscar
     * @return - lista de posts
     */
    @Query("{ $and: [" +
            " { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] }," +
            " { 'date': { $gte: ?1 } }," +
            " { 'date': { $lte: ?2 } } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
