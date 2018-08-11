package calendar.service;

import calendar.entity.Event;

import java.util.Date;
import java.util.List;

public interface EventService {
    void create(Event event);
    List<Event> getAll();
    Event getById(long Id);
    void update(Event event);
    void deleteById(long Id);
    List<Event> findByDate(Date eventDate);


}
