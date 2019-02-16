import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class App {
    private Client client;
    private ConsoleEventLogger eventLogger;

    public App(Client client, ConsoleEventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(Event event) {
        eventLogger.logEvent(event);
    }

    private static void close(ApplicationContext context) {
        ConfigurableApplicationContext ctx = (ConfigurableApplicationContext) context;
        ctx.close();
    }
}