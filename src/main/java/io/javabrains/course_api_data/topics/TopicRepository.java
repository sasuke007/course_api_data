package io.javabrains.course_api_data.topics;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topics,String> {

    //void delete(String id);
}
