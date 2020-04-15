package io.javabrains.springbootstarter.topic;

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

@RestController

public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping(value = "/topics")
	public List<Topic> getAllTopics() {

		return topicService.getAllTopics();
	}
	
	@GetMapping(value = "/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
		
	}
	
	@PostMapping(value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		
		topicService.addTopic(topic);
	}
	
	@RequestMapping( method = RequestMethod.PUT, value = "/topics/{Id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String Id) {
		
		topicService.updateTopic(topic,Id);
	}
	
	@RequestMapping( method = RequestMethod.DELETE, value = "/topics/{Id}")
	public void deleteTopic(@PathVariable String Id) {
		
		topicService.deleteTopic(Id);
	}
}
