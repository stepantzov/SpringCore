import java.util.List;

public class CombinedEventLogger implements EventLogger {
    CombinedEventLogger(List<EventLogger> eventLoggers) {
        loggers(eventLoggers);
    }

    public void logEvent(Event event) {
    }

    public void loggers(List<EventLogger> eventLoggers) {
        for (int i = 0; i < eventLoggers.size(); i++) {
            eventLoggers.get(i).logEvent(null);
        }
    }
}