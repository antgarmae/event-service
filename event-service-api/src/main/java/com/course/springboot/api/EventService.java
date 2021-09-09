package com.course.springboot.api;

import java.util.List;

import com.course.springboot.dto.Event;

public interface EventService {
	
	Event createEvent(Event event);
	Event updateEvent(Event event);
	Event getEvent(Long id);
	void deleteEvent(Long id);
	List<Event> getAllEvents();
	List<Event> getAllEventsByTitle(String title);
	
}
