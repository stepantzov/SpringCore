import java.io.File;
import java.io.IOException;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    int cashSize;
    List<Event> cache;
    private File file;

    CacheFileEventLogger(String fileName) {
        super(fileName);
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cashSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        FileEventLogger fileEventLogger = new FileEventLogger("fileName");
        for (int i = 0; i < cache.size(); i++) {
            fileEventLogger.logEvent(cache.get(i));
        }
    }

    public void destroy() {
        if (!cache.isEmpty()) writeEventsFromCache();
    }

    public void init() throws IOException {
        this.file = new File(fileName);
        file.canWrite();
    }
}