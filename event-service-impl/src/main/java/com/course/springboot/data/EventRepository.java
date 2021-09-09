package com.course.springboot.data;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.course.springboot.dto.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

	List<Event> findByTitle(String title);
	
	@Transactional
	@Lock(LockModeType.PESSIMISTIC_READ)
	@Modifying
	Event save(String title);
}
