package io.vignesh.springbootstarter.course;

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
public class CourseService {
	
	//Inject course Repository obj
	@Autowired
	CourseRepository courseRepository;

public List<Course> getAllCourses(String topicId) {
	List<Course> courses = new ArrayList<Course>();
	courseRepository.findByTopicId(topicId)
					.forEach(courses::add);
	return courses;
}

public Course getCourse(String id) {
	Course t;
	t=courseRepository.findById(id).get();
	return t;
}

public String addCourse(Course course) {
	courseRepository.save(course);
		return "success";
}

public String updateCourse(Course course,String id) {
	courseRepository.save(course);
	return "success";
}
  
public String deleteCourse(String id) {
	courseRepository.deleteById(id);
	return "success";
}
}