package core;

import Service.Service;

import java.util.List;

public class ShoppingCart extends Service<Ticket> {

    private double price;
    private int count;
    private Customer customer;

    public ShoppingCart(double price, int count, Customer customer) {
        this.price = price;
        this.count = count;
        this.customer = customer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void addToList(Ticket item) {
        super.addToList(item);
    }

    @Override
    public List<Ticket> getFromList() {
        return super.getFromList();
    }

    @Override
    public void removeAllFromList() {
        super.removeAllFromList();
    }

    @Override
    public void removeFromList(Ticket item) {
        super.removeFromList(item);
    }

    public void pay(double ticketPrice) {
        double balance;
        balance = (price * count) - ticketPrice;
        balance = balance * (-1);
        System.out.println("Thank you. Giving money: " + balance);
    }

    public double checkPayment() {
        return price * count;
    }
}