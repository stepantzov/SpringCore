import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

public class Event {
    private String id = UUID.randomUUID().toString();
    private String message;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        return id + " " + message + " " + dateFormat.format(date);
    }
}