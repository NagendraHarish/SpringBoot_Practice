package io.javabrains.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

import io.javabrains.springbootstarter.course.Course;

public interface TopicRepository extends CrudRepository<Topic, String>{

	
}
