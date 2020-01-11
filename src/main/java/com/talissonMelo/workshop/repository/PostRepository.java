package com.talissonMelo.workshop.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.talissonMelo.workshop.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	// Query Methods
	// https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
	// https://docs.spring.io/spring-data/data-document/docs/current/reference/html/

	List<Post> findByTitleContainingIgnoreCase(String text);

	// @Query
	// https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
	// https://docs.spring.io/spring-data/data-document/docs/current/reference/html/
	// https://docs.mongodb.com/manual/reference/operator/query/regex/

	@Query("{ 'title': { $regex: ?0 , $options: 'i'} }")
	List<Post> searchTitle(String text);

	@Query("{ $and: [ { date : {$gte : ?1} } , {  $and: [ { date : {$lte : ?2} } , { $or : [ { 'title': { $regex: ?0 , $options: 'i'} } , { 'body': { $regex: ?0 , $options: 'i'} } , { 'comments.text': { $regex: ?0 , $options: 'i'} } ] } ]}")
	List<Post> fullSearch(String text , Date minDate, Date maxDate);
}
