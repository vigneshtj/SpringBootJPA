package io.vignesh.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/* This interface does all CRUD operation
 * The implementations for CRUD methods are available in CrudRepository
 * It has two generic types 1. Entity class name 2. Type of the primary key
*/

public interface CourseRepository extends CrudRepository<Course,String> {
	
	/*Customised methods can be created just by providing the declaration in the interface
	 * spring data JPA will use the name to figure out the implementation required
	 * naming convention is 
	 * findBy<property to be filtered><subproperty inside property>(any parameter)
	 */
	public List<Course> findByTopicId(String id);
}
