package core;

public class TicketCounterAdapter implements  AdapterTicketCounter {

    TicketCounter  ticketCounter;

    @Override
    public int countTicketsByCustomer(PersonalInfo personalInfo) {
        Customer customer = new Customer(personalInfo.getName(), personalInfo.getSurname());
        return ticketCounter.getTicketByCustomer(customer);
    }

    public TicketCounterAdapter(TicketCounter ticketCounter) {
        this.ticketCounter = ticketCounter;
    }
}