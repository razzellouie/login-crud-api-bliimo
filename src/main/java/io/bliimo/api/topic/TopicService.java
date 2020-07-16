package io.bliimo.api.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service	
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics(){
		return topicRepository.findAll();
	}

	public Topic getTopic(Long id) {
		if (topicRepository.findOne(id) == null) {
			throw new RuntimeException("ID does not exist!");
		}
		return topicRepository.findOne(id);
		
	}

	public Topic addTopic(Topic request) {
		Topic topic = new Topic();
		if (topicRepository.findByName(request.getName()) != null) {
			throw new RuntimeException("Name exist!");
		}
		topic.setDescription(request.getDescription());
		topic.setName(request.getName());
		
		return topicRepository.save(topic);
	}

	public Topic updateTopic(Topic request, Long id) {
		Topic topic = topicRepository.findOne(id);
		if (topic == null || topicRepository.findByNameAndIdNot(request.getName(), id) != null)  {
			throw new RuntimeException("topic not found or name does exist!");
		}
		topic.setDescription(request.getDescription());
		topic.setName(request.getName());
		
		return topicRepository.save(topic);
	}
	
	public String deleteTopic(Long id) {
		if (topicRepository.findOne(id) == null) {
			throw new RuntimeException("ID does not exist!");
		}
		topicRepository.delete(id);
		return "Success";
	}
	
}
