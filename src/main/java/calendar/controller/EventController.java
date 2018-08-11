package calendar.controller;

import calendar.entity.Event;
import calendar.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    Logger logger = LoggerFactory.getLogger(EventController.class);

    /**
     * auto wiring the event repository.
     */
    @Autowired
    EventRepository eventRepository;

    @RequestMapping(value="/ping", method=RequestMethod.GET)
    public ResponseEntity<String> sayHello() {
        logger.info("health check is okay");
        return new ResponseEntity<>("Pong!",HttpStatus.OK);
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<Event> allEvents() {
        logger.info("all events pulled successfully");

        return eventRepository.findAll();

    }

    @RequestMapping(value="/add", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> addEvent(@RequestBody Event event) {
        logger.info("add events successful");
        eventRepository.save(event);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/update", method=RequestMethod.PATCH)
    public Event updateEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @RequestMapping(value="/delete", method=RequestMethod.DELETE)
    public void deleteEvent(@RequestBody Event event) {
        eventRepository.delete(event);
    }

    @RequestMapping(value="/byDate", method=RequestMethod.GET)
    public List<Event> getEventsDate(@RequestParam(value = "start", required = true) String start, @RequestParam(value = "end", required = true) String end) {

        Date startDate, endDate;
        SimpleDateFormat inputDateFormat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        try {
            startDate = inputDateFormat.parse(start+"T00:00:00");
            endDate = inputDateFormat.parse(end+"T23:59:59");
        } catch (ParseException e) {
            throw new BadDateFormatException("bad date: start=" + start + ", end=" + end);
        }

        return eventRepository.findByEventDateGreaterThanEqualAndEventDateLessThanEqual(startDate, endDate);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    class BadDateFormatException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public BadDateFormatException(String dateString) {
            super(dateString);
        }
    }

}
