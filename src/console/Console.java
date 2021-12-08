package console;

import core.*;
import exception.BandException;
import exception.TicketException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Console {

    private Schedule schedule;
    private Festival festival;
    private List<Ticket> tickets;
    private List<Schedule> schedules = new ArrayList<>();
    private Map<Customer, List<Ticket>> marketHistory = new HashMap<>();

    /**
     * console menu, allows to select options.
     */
    public void startTicketsMenu() {
        if (schedule == null || festival == null) {
            System.out.println("Schedule or Festival was not created yet");
            return;
        }
        Scanner input = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("Enter your choice:\n" +
                    "1. Create a ticket\n" +
                    "2. Show sold tickets\n" +
                    "3. Show sold ticket by user\n" +
                    "4. Buy a ticket\n" +
                    "5. Back");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    try {
                        addTicket();
                    } catch (TicketException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    allSoldTickets();
                    break;
                case 3:
                    soldTickets();
                    break;
                case 4:
                    buyTicket();
                    break;
            }
        }
    }

    /**
     * Structural pattern adapter. The method displays the number of sold tickets by customer.
     */
    private void soldTickets() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of customer: ");
        String name = input.nextLine();
        System.out.println("Enter the surname of customer: ");
        String surname = input.nextLine();
        System.out.println("Enter sex:  M / Z");
        char sex = input.next().charAt(0);
        boolean gender = sex == 'M';
        PersonalInfo personalInfo = new PersonalInfo(name, surname, gender);
        TicketCounter ticketCounter = new TicketCounter(marketHistory);
        TicketCounterAdapter ticketCounterAdapter = new TicketCounterAdapter(ticketCounter);
        System.out.println("Bought ticket by Customer: " + ticketCounterAdapter.countTicketsByCustomer(personalInfo));
    }

    /**
     * Builder design pattern. The method will create tickets that will be for sale.
     *
     * @throws TicketException
     */
    private void addTicket() throws TicketException {
        Scanner input = new Scanner(System.in);
        System.out.println("Parking Y / N:");
        char isPossible = input.next().charAt(0);
        boolean parking = false;
        if (isPossible == 'Y') {
            parking = true;
        }
        System.out.println("Enter the number of days: ");
        int days = input.nextInt();
        System.out.println("Enter the number of ticket: ");
        int count = input.nextInt();
        System.out.println("Enter the price of one ticket: ");
        double price = input.nextDouble();

        try {
            TicketBuilder ticketBuilder = new TicketBuilder();
            ticketBuilder.setFestivalName(festival.getName());
            ticketBuilder.setConcertDate(festival.getDate());
            ticketBuilder.setPrice(price);
            ticketBuilder.setConcertLocation(festival.getCountry());
            ticketBuilder.setParking(parking);
            ticketBuilder.setNumberOfDays(days);
            ticketBuilder.setCount(count);
            tickets = ticketBuilder.build();
        } catch (Exception e) {
            throw new TicketException("Error to add ticket", e);
        }

    }

    /**
     * The method displays the number of all sold tickets.
     */
    private void allSoldTickets() {
        TicketCounter ticketCounter = new TicketCounter(marketHistory);
        System.out.println("Number of tickets: " + ticketCounter.getAllTickets());
    }

    /**
     * The user creates a customer who can buy previously created tickets.
     * It also maps purchased tickets to a new list.
     */
    private void buyTicket() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of customer: ");
        String name = input.nextLine();
        System.out.println("Enter the surname of customer: ");
        String surname = input.nextLine();
        System.out.println("Enter the address of customer: ");
        String address = input.nextLine();
        System.out.println("Enter the email of customer: ");
        String email = input.nextLine();
        System.out.println("Enter the telephone number of customer: ");
        String telephone = input.nextLine();
        Customer customer = new Customer(name, surname, address, email, telephone);
        Ticket ticket = tickets.stream().findFirst().get();
        System.out.println(ticket);
        System.out.println("how many ticket you want to buy ?");
        int count = input.nextInt();
        ShoppingCart shoppingCart = new ShoppingCart(ticket.getPrice(), count, customer);
        System.out.println("you need to pay: " + shoppingCart.checkPayment());
        double ticketPrice = input.nextDouble();

        if (ticketPrice >= shoppingCart.checkPayment()) {
            shoppingCart.pay(ticketPrice);
        } else {
            while (shoppingCart.checkPayment() > ticketPrice) {
                System.out.println("You still need to pay: " + (shoppingCart.checkPayment() - ticketPrice));
                double needToPay = input.nextDouble();
                ticketPrice = ticketPrice + needToPay;
            }
        }

        List<Ticket> bought = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Ticket t = tickets.get(i);
            tickets.remove(i);
            bought.add(t);
        }

        marketHistory.put(customer, bought);

        System.out.println("Customer: " + shoppingCart.getCustomer() + "bought ticket to festival");
    }

    /**
     * A console menu that can be used to create a schedule.
     */
    public void startSchedulesMenu() {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        System.out.println("Enter date in format DD/MM/YYYY: ");
        String sdate = input.nextLine();
        System.out.println("Enter time in HH:mm:  ");
        String time = input.nextLine();

        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sdate);
            schedule = new Schedule(date, time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (schedule != null) {
            while (choice != 6 && choice != 5) {
                System.out.println("Enter your choice:\n" +
                        "1. Add a band\n" +
                        "2. Add stage\n" +
                        "3. Add manager\n" +
                        "4. Show information about schedule\n" +
                        "5. Save schedule\n" +
                        "6. Exit");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        try {
                            createBand();
                        } catch (BandException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        createStage();
                        break;
                    case 3:
                        createManager();
                        break;
                    case 4:
                        showSchedule();
                        break;
                    case 5:
                        saveSchedule();
                        break;
                }
            }
        }
    }

    /**
     * deletes the created schedules.
     */
    public void deleteSchedule() {
        schedules.clear();
    }

    /**
     * console menu to create and add a band.
     *
     * @throws BandException
     */
    private void createBand() throws BandException {
        Scanner input = new Scanner(System.in);
        System.out.println("Add band name");
        String name = input.nextLine();
        System.out.println("Add band country");
        String country = input.nextLine();
        System.out.println("Add band description");
        String description = input.nextLine();
        System.out.println("Enter the number of members");
        int numberOfMembers = input.nextInt();
        try {
            Band band = new Band(name, country, description, numberOfMembers);
            schedule.setBand(band);
            schedule.addToList(band);
        } catch (Exception e) {
            throw new BandException("Error to add band to list", e);
        }
        if (schedule.getBand() != null) {
            System.out.println("The band has been added");
        }
    }

    /**
     * Console menu to create and add a stage.
     */
    private void createStage() {
        Scanner input = new Scanner(System.in);
        System.out.println("Add stage name: ");
        String name = input.nextLine();
        System.out.println("Is stage covered ? Y / N");
        char covered = input.next().charAt(0);
        boolean isCovered = false;
        if (covered == 'Y') {
            isCovered = true;
        }
        schedule.setStage(new Stage(name, isCovered));
    }

    /**
     * Console menu to create and add manager.
     */
    private void createManager() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the manager: ");
        String name = input.nextLine();
        System.out.println("Enter the surname of the manager: ");
        String surname = input.nextLine();
        System.out.println("Enter the email of the manager: ");
        String email = input.nextLine();
        System.out.println("Enter the telephone of the manager: ");
        String telephone = input.nextLine();
        schedule.setManager(new Manager(name, surname, email, telephone));
    }

    /**
     * Display created schedule.
     */
    private void showSchedule() {
        System.out.println(schedule);
    }

    /**
     * Save created schedule.
     */
    private void saveSchedule() {
        schedules.add(schedule);
    }

    /**
     * Return all created schedules.
     *
     * @return List<Schedule>
     */
    public ArrayList<Schedule> getSchedules() {
        return new ArrayList<Schedule>(schedules);
    }

    /**
     * Console menu to create and add festival.
     */
    public void startFestival() {
        Scanner input = new Scanner(System.in);
        if (schedule == null) {
            System.out.println("Schedule was not created yet");
            return;
        }

        System.out.println("Add the name of the festival: ");
        String name = input.nextLine();
        System.out.println("Add the country where the festival will be: ");
        String country = input.nextLine();
        System.out.println("Add festival address: ");
        String address = input.nextLine();
        System.out.println("Add the date of the festival DD/MM/YYYY: ");
        String sdate = input.nextLine();
        Date date = null;

        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(sdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        festival = new Festival(name, country, address, date);
        festival.setSchedule(schedules);
    }

    /**
     * Display all information about created festival.
     */
    public void showFestivalInformation() {
        if (festival == null) {
            System.out.println("Festival was not created yet");
            return;
        }
        System.out.println(festival);
    }

    /**
     * Display all created bands.
     */
    public void showAllBands() {
        System.out.println("All bands: " + schedule.getFromList());
    }
}