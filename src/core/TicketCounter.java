package core;

import java.util.List;
import java.util.Map;

public class TicketCounter {

    private Map<Customer, List<Ticket>> marketHistory;

    public TicketCounter(Map<Customer, List<Ticket>> marketHistory) {
        this.marketHistory = marketHistory;
    }

    public int getAllTickets() {
        int numberOfSoldTickets = 0;

        if (marketHistory != null) {
            for (List<Ticket> tickets : marketHistory.values()) {
                numberOfSoldTickets = numberOfSoldTickets + tickets.size();
            }
        }
        return numberOfSoldTickets;
    }

    public int getTicketByCustomer(Customer customer) {
        List<Ticket> tickets = marketHistory.get(customer);

        if (tickets == null) {
            return 0;
        }
        return tickets.size();
    }
}