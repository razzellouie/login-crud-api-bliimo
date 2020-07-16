package io.bliimo.api.topic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

	Topic findByName(String name);

	Topic findByNameAndIdNot(String name, Long id);

}
