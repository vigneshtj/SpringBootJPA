package io.vignesh.springbootstarter.topic;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Create rest service
@RestController
public class TopicController{
	

	//@Autowired injects autowired instance of topicservice
	@Autowired
	private TopicService topicservice;
	
	
/*
 * @RequestMapping is default to Get method. 
 * For other methods, specify in annotation	
 */
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicservice.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")	
	//@Path variable to denote path parameter
	public Topic getTopic(@PathVariable String id) {
		return topicservice.getTopic(id);
	}

	//Request mapping for POST method
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public String addTopic(@RequestBody Topic t) {
		return topicservice.addTopic(t);
	}
	
	//Request mapping for PUT method
		@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
		public String updateTopic(@RequestBody Topic t,@PathVariable String id) {
			return topicservice.updateTopic(t,id);
		}
		
		//Request mapping for DELETE method
				@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
				public String updateTopic(@PathVariable String id) {
					return topicservice.deleteTopic(id);
				}
}