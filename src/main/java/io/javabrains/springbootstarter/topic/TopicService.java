package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository repository;
	/*
	 * private List<Topic> topics = new ArrayList<Topic>( Arrays.asList(new
	 * Topic("Spring", "SpringFramework", "SpringFramework Description"), new
	 * Topic("Java", "Core Java", "Core Java Description"), new Topic("Javascript",
	 * "Javascript", "Javascript")));
	 */

	public List<Topic> getAllTopics() {
		//return topics;
		List<Topic> topics= new ArrayList<Topic>();
		 repository.findAll().forEach(topics::add);
		 return topics;
	}

	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return repository.findById(id).get();
	}

	public void addTopic(Topic topic) {
		repository.save(topic);
	}
	
	public void updateTopic(Topic topic, String id) {
		/*
		 * 
		 * for (int i = 0; i < topics.size(); i++) { Topic t= topics.get(i); if(
		 * t.getId().equals(id)) { topics.set(i, topic); } }
		 */
		//Repo know which Row to update based on Id in topic
		repository.save(topic);
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t->t.getId().equals(id));
		repository.deleteById(id);
	}
}
