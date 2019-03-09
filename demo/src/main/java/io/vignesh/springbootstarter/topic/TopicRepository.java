package io.vignesh.springbootstarter.topic;

import org.springframework.data.repository.CrudRepository;

/* This interface does all CRUD operation
 * The implementations for CRUD methods are available in CrudRepository
 * It has two generic types 1. Entity class name 2. Type of the primary key
*/

public interface TopicRepository extends CrudRepository<Topic,String> {

}
