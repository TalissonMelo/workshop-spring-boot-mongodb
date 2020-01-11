package com.talissonMelo.workshop.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.talissonMelo.workshop.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	// Query Methods
	// https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
	// https://docs.spring.io/spring-data/data-document/docs/current/reference/html/
	List<Post> findByTitleContainingIgnoreCase(String text);

}
