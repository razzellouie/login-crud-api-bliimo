package io.bliimo.api.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TopicController {
	
	//Mapping means HTTP Method (CRUD)
	//This java file is a controller
	//Topic is a Java class
	
	//for connecting to Topic Service
	@Autowired
	private TopicService topicService;
	
	//requesting map for /topics GET METHOD
	@GetMapping("/topics")
	public ResponseEntity<?> getAllTopics(){
		return new ResponseEntity<Object>(topicService.getAllTopics(), HttpStatus.OK);
	}
	
	//requesting map for /topics/with ID GET METHOD
	//Topic is the Java Class
	//getTopic is the name of the method
	@GetMapping("/topics/{id}")
	public ResponseEntity<?> getTopic(@PathVariable Long id) {
		return new ResponseEntity<Object>(topicService.getTopic(id), HttpStatus.OK);
	}
	
	//requesting map for POST method
	//@RequestBody converts HTTPRequest to Java Object
	@PostMapping("/topics")
	public ResponseEntity<?> addTopic(@RequestBody Topic topic) {
		return new ResponseEntity<Object>(topicService.addTopic(topic), HttpStatus.CREATED);
	} 
	
	//requesting map for UPDATE method
	//request body is the JSON body file that you send in post man
	//path variable is the ID of topic you wanted to update
	@PutMapping("/topics/{id}")
	public ResponseEntity<?> updateTopic(@RequestBody Topic topic, @PathVariable Long id) {
		return new ResponseEntity<Object>(topicService.updateTopic(topic, id), HttpStatus.ACCEPTED);
	}
	
	//requesting map for DELETE method
	//calling the method deleteTopic in topicService
	@DeleteMapping("/topics/{id}")
	public ResponseEntity<?> deleteTopic(@PathVariable Long id) {
		return new ResponseEntity<Object>(topicService.deleteTopic(id), HttpStatus.OK);
	}
	
	

}
