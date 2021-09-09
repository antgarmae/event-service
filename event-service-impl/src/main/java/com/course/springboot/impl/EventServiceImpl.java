package com.course.springboot.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.course.springboot.api.EventService;
import com.course.springboot.data.EventRepository;
import com.course.springboot.dto.Event;

@Service
public class EventServiceImpl implements EventService {

private final EventRepository eventRepository;
	
	public EventServiceImpl(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public Event createEvent(Event event) {
		return eventRepository.save(event);
	}

	public Event updateEvent(Event event) {
		Long id = event.getId();
		if(eventRepository.existsById(id)) {
		    return eventRepository.save(event);
		}else {
			throw new NoSuchElementException(String.valueOf(id));
		}
	}

	public Event getEvent(Long id) {
		return eventRepository.findById(id).orElseThrow();
	}

	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
	}

	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	@Override
	public List<Event> getAllEventsByTitle(String title) {
		return eventRepository.findByTitle(title);
	}
}
