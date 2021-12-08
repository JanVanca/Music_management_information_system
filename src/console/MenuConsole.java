package console;

import java.util.Scanner;

public class MenuConsole {

    Console console = new Console();

    /**
     * Turns on the first console menu
     */
    public void start() {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        while (choice != 8) {
            System.out.println("Enter your choice:\n" +
                    "1. Create schedule\n" +
                    "2. Show schedules\n" +
                    "3. Remove schedules\n" +
                    "4. Add Schedules to Festival\n" +
                    "5. Show information about Festival\n" +
                    "6. Show all bands\n" +
                    "7. Ticket\n" +
                    "8. Exit");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    scheduleMenu();
                    break;
                case 2:
                    showSchedules();
                    break;
                case 3:
                    deleteSchedule();
                    break;
                case 4:
                    createFestival();
                    break;
                case 5:
                    showInformationAboutFestival();
                    break;
                case 6:
                    showAllBands();
                    break;
                case 7:
                    ticketsMenu();
                    break;
                case 8:
                    System.out.println("Bye");
                    break;
            }
            if (choice < 1 || choice > 8) {
                System.out.println("Wrong choice");
            }
        }
    }

    /**
     * Starts Ticket menu console.
     */
    private void ticketsMenu() {
        console.startTicketsMenu();
    }

    /**
     * Shows all bands.
     */
    private void showAllBands() {
        console.showAllBands();
    }

    /**
     * Starts schedule menu console.
     */
    private void scheduleMenu() {
        console.startSchedulesMenu();
    }

    /**
     * Clears the plan.
     */
    private void deleteSchedule() {
        console.deleteSchedule();
    }

    /**
     * Shows all schedules.
     */
    private void showSchedules() {
        System.out.println(console.getSchedules());
    }

    /**
     * Starts console to create festival.
     */
    private void createFestival() {
        console.startFestival();
    }

    /**
     * Shows all information about festival.
     */
    private void showInformationAboutFestival() {
        console.showFestivalInformation();
    }
}