package io.vignesh.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * business services are usually singleton class
 * in string, a business services can be created using @service annotation
 */

@Service
public class TopicService {
	
	//Inject Topic Repository obj
	@Autowired
	TopicRepository topicRepository;
	
	/*List<Topic> topics = new ArrayList<Topic>();
	
	 * List<Topic> topics = new ArrayList<Topic>(Arrays.asList( new
	 * Topic("java","java book","desc1"), new Topic("spring","spring book","desc2"),
	 * new Topic("spring boot","spring boot book","desc3") ));
	 */

public List<Topic> getAllTopics() {
	List<Topic> topics = new ArrayList<Topic>();
	topicRepository.findAll()
					.forEach(topics::add);
	return topics;
}

public Topic getTopic(String id) {
	Topic t;
	t=topicRepository.findById(id).get();
	return t;
}

public String addTopic(Topic topic) {
	topicRepository.save(topic);
		return "success";
}

public String updateTopic(Topic topic,String id) {
	topicRepository.save(topic);
	return "success";
}
  
public String deleteTopic(String id) {
			//topics.removeIf(t->t.getId().equals(id));
	topicRepository.deleteById(id);
	return "success";
}
}