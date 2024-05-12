/**
 * Represents a calendar event.
 */
public class Event {
    private String title;
    private String date;

    public Event(String title, String date) {
        this.title = title;
        this.date = date;
    }

    /**
     * Returns a string representation of the event.
     */
    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
