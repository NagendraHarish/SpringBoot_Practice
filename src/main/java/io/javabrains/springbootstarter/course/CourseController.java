package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController

public class CourseController {

	@Autowired
	private CourseService topicService;

	@RequestMapping(value = "/topics/{id}/courses")
	public List<Course> getAllCourse(@PathVariable String id) {

		return topicService.getAllCourse(id);
	}
	
	@GetMapping(value = "/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return topicService.getCourse(id);
		
	}
	
	@PostMapping(value = "/topics/{topicId}/courses")
	public void addTopic(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		topicService.addCourse(course);
	}
	
	@RequestMapping( method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{Id}")
	public void updateTopic(@RequestBody Course course,@PathVariable String topicId,@PathVariable String Id) {
		
		course.setTopic(new Topic(topicId, "", ""));
		topicService.updateCourse(course,Id);
	}
	
	@RequestMapping( method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{Id}")
	public void deleteTopic(@PathVariable String Id) {
		
		topicService.deleteCourse(Id);
	}
}
