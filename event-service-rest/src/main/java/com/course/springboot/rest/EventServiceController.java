package com.course.springboot.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.springboot.api.EventService;
import com.course.springboot.dto.Event;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@RestController
public class EventServiceController {

	private final EventService eventService;

	public EventServiceController(EventService eventService) {
		this.eventService = eventService;
	}

	@ApiOperation(value = "Returns an event by ID")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successful operation", response=Event.class ),
	        @ApiResponse(code = 404, message = "Event not found"),
	        @ApiResponse(code = 500, message = "Unexpected error")})
	@GetMapping("/api/events/{eventId}")
	public Event getEventById(@ApiParam("Event ID, required") @PathVariable("eventId") long eventId){
		return eventService.getEvent(eventId);
	}
	
	@ApiOperation(value = "Returns all events that match the tile (or all if not sent)")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "List of Events", response=List.class ),
	        @ApiResponse(code = 500, message = "Unexpected error")})
	@GetMapping("/api/events")
	public List<Event> getEventsByTitle(@ApiParam("Event Title, not required") @RequestParam(required = false) String title){
		if(title == null) {
			return eventService.getAllEvents();
		} else {
			return eventService.getAllEventsByTitle(title);
		}
	}

	@ApiOperation(value = "Deletes an event by ID")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Deletion Successful", response=ResponseEntity.class ),
	        @ApiResponse(code = 404, message = "Event not found"),
	        @ApiResponse(code = 500, message = "Unexpected error")})
	@DeleteMapping("/api/events/{eventId}")
	public ResponseEntity<?> deleteEvent(@ApiParam("Event ID, required") @PathVariable("eventId") long eventId) {
		eventService.deleteEvent(eventId);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Deletes an event by ID")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Creation Successful", response=Event.class ),
	        @ApiResponse(code = 500, message = "Unexpected error")})
	@PostMapping("/api/events")
	public Event addEvent(@Valid @RequestBody Event event) {
		return eventService.createEvent(event);
	}

	@ApiOperation(value = "Updates an event by ID")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Update Successful", response=Event.class ),
	        @ApiResponse(code = 404, message = "Event not found"),
	        @ApiResponse(code = 500, message = "Unexpected error")})
	@PutMapping("/api/events/{eventId}")
	public Event replaceEvent(@Valid @RequestBody Event event, @ApiParam("Event ID, required") @PathVariable("eventId") long eventId) {
		return eventService.updateEvent(event);
	}

}
