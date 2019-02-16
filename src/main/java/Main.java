import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) applicationContext.getBean("app");

        Event event = (Event) applicationContext.getBean("event");
        event.setMessage("Some event for 1");

        app.logEvent(event);

        Event event2 = (Event) applicationContext.getBean("event");
        event2.setMessage("Some event for 2");

        app.logEvent(event2);
    }
}