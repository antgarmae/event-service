package com.course.springboot.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Event {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank(message = "Event place is mandatory")
    @NotNull(message = "Event place is mandatory")
	private String title;
	
	@NotBlank(message = "Event place is mandatory")
    @NotNull(message = "Event place is mandatory")
	private String place;
	
	@NotBlank(message = "Event speaker is mandatory")
    @NotNull(message = "Event speaker is mandatory")
	private String speaker;
	
    @NotNull(message = "Event type is mandatory")
	private EventType eventType;
	
	@NotNull(message = "Event date is mandatory")
	private LocalDateTime dateTime;
	
}
