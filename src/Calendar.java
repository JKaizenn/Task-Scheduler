import java.util.ArrayList;

/**
 * Manages event storage and operations.
 */
public class Calendar implements Manageable {
    private ArrayList<Event> events;

    public Calendar() {
        events = new ArrayList<>();
    }

    /**
     * Adds a new event.
     */
    @Override
    public void addEvent(String title, String date) {
        events.add(new Event(title, date));
        System.out.println("Event added: " + title);
    }

    /**
     * Displays all events.
     */
    @Override
    public void listEvents() {
        for (Event event : events) {
            System.out.println(event);
        }
    }
}
