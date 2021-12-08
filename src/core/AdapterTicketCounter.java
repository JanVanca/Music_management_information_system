package core;

public interface AdapterTicketCounter {

    /**
     * Adapter structural pattern
     *
     * @param personalInfo
     * @return
     */
    int countTicketsByCustomer(PersonalInfo personalInfo);
}
