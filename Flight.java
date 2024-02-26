package AirlineReservationSystem;


import java.util.Random;
import java.util.ArrayList;


public class Flight {
    private int flightNo;
    private final int totalSeats = 30;
    private int bookedSeats ;
    private double seatCost;
    private ArrayList<Ticket> tickets;

    public Flight(int flightNo ){
        Random rand = new Random();
        this.flightNo = flightNo;
        this.tickets = new ArrayList<>();
        this.seatCost = 1000 * rand.nextDouble();
        this.bookedSeats = rand.nextInt(31);
    }

    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
    }

    public int getFlightNo(){
        return this.flightNo;
    }

    public double getCost(){
        return this.seatCost;
    }

    public boolean checkAvailability(){
        return this.bookedSeats < this.totalSeats;
    }

    public void increaseSeat(){
        this.bookedSeats++;
    }

    public int getBookedSeats(){
        return this.bookedSeats;
    }

    public int getTotalSeats(){
        return this.totalSeats;
    }
}
