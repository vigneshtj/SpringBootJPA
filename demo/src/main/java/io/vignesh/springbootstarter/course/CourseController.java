package io.vignesh.springbootstarter.course;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.vignesh.springbootstarter.topic.Topic;

//Create rest service
@RestController
public class CourseController{
	

	//@Autowired injects autowired instance of topicservice
	@Autowired
	private CourseService courseService;
	
	
/*
 * @RequestMapping is default to Get method. 
 * For other methods, specify in annotation	
 */
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllTopics(@PathVariable String topicId) {
		return courseService.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")	
	//@Path variable to denote path parameter
	public Course getCourse(@PathVariable String courseId) {
		return courseService.getCourse(courseId);
	}

	//Request mapping for POST method
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public String addTopic(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		return courseService.addCourse(course);
	}
	
	//Request mapping for PUT method
		@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}")
		public String updateCourse(@RequestBody Course course,@PathVariable String topicId,@PathVariable String courseId) {
			course.setTopic(new Topic(topicId,"",""));
			return courseService.updateCourse(course,courseId);
		}
		
		//Request mapping for DELETE method
				@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}")
				public String updateTopic(@PathVariable String courseId) {
					return courseService.deleteCourse(courseId);
				}
}