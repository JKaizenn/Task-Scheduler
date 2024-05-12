import java.util.Scanner;

/**
 * Manages task scheduling operations through a CLI.
 */
public class TaskScheduler {
    private Calendar calendar;

    public TaskScheduler() {
        calendar = new Calendar();
    }

    /**
     * Provides CLI for adding, listing, or quitting event management.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an option: (1) Add Event (2) List Events (3) Quit");
            int choice = getIntInput(scanner, 1, 3); // Get valid integer input for menu options

            switch (choice) {
                case 1:
                    String title = getStringInput(scanner, "Enter event title:");
                    String date = getDateInput(scanner, "Enter event date (dd-MM-yyyy):");
                    calendar.addEvent(title, date);
                    break;
                case 2:
                    calendar.listEvents();
                    break;
                case 3:
                    running = false;  // Exit the loop and prepare to end the application
                    System.out.println("Thank you for using the Task Scheduler. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    /**
     * Prompts the user for an integer and validates the range.
     */
    private int getIntInput(Scanner scanner, int min, int max) {
        int choice = 0;
        boolean valid = false;
        while (!valid) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    valid = true;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        }
        scanner.nextLine(); // Consume newline
        return choice;
    }

    /**
     * Prompts the user for a string and checks if it's empty.
     */
    private String getStringInput(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }

    /**
     * Prompts the user for a date string and validates it matches a specific pattern.
     */
    private String getDateInput(Scanner scanner, String prompt) {
        String input;
        boolean valid = false;
        do {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            if (input.matches("\\d{2}-\\d{2}-\\d{4}")) {
                valid = true;
            } else {
                System.out.println("Invalid date format. Please use dd-MM-yyyy format.");
            }
        } while (!valid);
        return input;
    }
}
