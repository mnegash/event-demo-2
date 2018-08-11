package calendar.repository;

import calendar.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
        List<Event> findAll();
        Event save(Event event);
        void delete(Event event);
        List<Event> findByEventDateGreaterThanEqualAndEventDateLessThanEqual(Date startDate, Date endDate);
        //List<Event> findByName(String lastName);

        //@Query("select b from Event b " +
        //        "where b.start between ?1 and ?2 and b.end between ?1 and ?2")
        //List<Event> findByDatesBetween(Date start, Date end);

}
