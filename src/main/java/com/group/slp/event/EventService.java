package com.group.slp.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Page<Event> datedEvents(String min, String max, Pageable pageable) {
        LocalDate now = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate minDate = min.equals("") ? now.minusDays(30) : LocalDate.parse(min);
        LocalDate maxDate = min.equals("") ? now : LocalDate.parse(max);

        return eventRepository.findAllBetweenDate(minDate, maxDate, pageable);
    }



}
