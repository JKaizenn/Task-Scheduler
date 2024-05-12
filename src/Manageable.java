/**
 * Interface for managing events within the calendar system.
 */
public interface Manageable {
    /**
     * Adds an event to the management system.
     * @param title The title of the event.
     * @param date The date of the event.
     */
    void addEvent(String title, String date);

    /**
     * Lists all events managed by the system.
     */
    void listEvents();
}
