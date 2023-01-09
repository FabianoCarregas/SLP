package com.group.slp.message;

import com.group.slp.event.Event;
import com.group.slp.event.EventRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MessageService {

    @Value("${twilio.sid}")
    private String twilioSid;
    @Value("${twilio.key}")
    private String twilioKey;
    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;
    @Value("${twilio.phone.to}")
    private String twilioPhoneto;

    private EventRepository eventRepository;

    public MessageService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void sendMsg(Long id) {
        Twilio.init(twilioSid, twilioKey);
        String msg = "Event defaut";
        Optional<Event> event = eventRepository.findById(id);
        if (event.isPresent()) {
            Event ev = event.get();
            msg = "Your appointment " + ev.getMessage() + " is at: " + ev.getDate() + " be ready!";
        }
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
        PhoneNumber to = new PhoneNumber(twilioPhoneto);

        Message message = Message.creator(to, from, msg).create();
        System.out.println(message.getSid());
    }
}
