package com.group.slp.event;

import com.group.slp.message.MessageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/events")
public class EventController {


    private EventService eventService;
    private MessageService messageService;

    public EventController(EventService eventService, MessageService messageService) {
        this.eventService = eventService;
        this.messageService = messageService;
    }

    @GetMapping("/dated")
    public Page<Event> findAll(
            @RequestParam(value = "minDate", defaultValue = "") String minDatePageable,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDatePageable,
            Pageable pageable) {
        return eventService.datedEvents(minDatePageable, maxDatePageable, pageable);
    }

    @GetMapping("/notication/{id}")
    public void notifyMsg(@PathVariable Long id) {
        messageService.sendMsg(id);
    }
}
