package com.group.slp.event;

import com.group.slp.enums.Priority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String event;
    private Priority priority;
    private String message;
    private LocalDate date;

    @Deprecated
    public Event() {
    }

    public Event(Long id, String event, Priority priority, String message, LocalDate date) {
        this.id = id;
        this.event = event;
        this.priority = priority;
        this.message = message;
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public LocalDate getDate() {
        return date;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getMessage() {
        return message;
    }
}
