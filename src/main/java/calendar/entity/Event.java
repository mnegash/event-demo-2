package calendar.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event {

    @GenericGenerator(
            name = "eventsSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "eventsSequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )

    @Id
    @GeneratedValue(generator = "eventsSequenceGenerator")
    private Long id;

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    private String calendar;
    private String title;
    private String description;
    private Date eventDate;
    private String location;
    private String attendeeList;
    private Date reminderTime;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAttendeeList() {
        return attendeeList;
    }

    public void setAttendeeList(String attendeeList) {
        this.attendeeList = attendeeList;
    }

    public Date getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(Date reminderTime) {
        this.reminderTime = reminderTime;
    }

    public boolean isReminderSent() {
        return isReminderSent;
    }

    public void setReminderSent(boolean reminderSent) {
        isReminderSent = reminderSent;
    }

    private boolean isReminderSent;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
//    public Date getStart() {
//        return start;
//    }
//    public void setStart(Date start) {
//        this.start = start;
//    }
//    public Date getEnd() {
//        return end;
//    }
//    public void setEnd(Date end) {
//        this.end = end;
//    }
    public Event(Long id, String title, String description, Date eventDate, String location,
                 String attendeeList, Date reminderTime, Date date) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.attendeeList = attendeeList;
        this.eventDate = eventDate;
        this.location = location;
        this.reminderTime = reminderTime;
        this.date = date;


    }
    public Event() {
        super();
    }
    @Override
    public String toString() {
        return "Event [id=" + id + ", title=" + title + ", description=" + description
                + ", eventDate=" + eventDate + "]";// + ", start=" + start + ", end=" + end + "]";
    }
}