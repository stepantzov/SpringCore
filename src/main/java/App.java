import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private Map<EventType, EventLogger> loggers;
    private Event event;
    private EventLogger defaultLogger;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public void logEvent(EventType eventType, String msg) {
        EventLogger eventLogger = loggers.get(eventType);
        if (eventLogger == null) {
            eventLogger = defaultLogger;
        }
        eventLogger.logEvent(event);
    }

    private static void close(ApplicationContext context) {
        ConfigurableApplicationContext ctx = (ConfigurableApplicationContext) context;
        ctx.close();
    }
}