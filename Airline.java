package AirlineReservationSystem;


import java.util.ArrayList;
import java.util.Random;


public class Airline {
    private ArrayList<User> users;
    private ArrayList<Flight> flights;
    private ArrayList<Ticket> tickets;

    public Airline(){
        this.users = new ArrayList<>();
        this.flights = new ArrayList<>();
        this.tickets = new ArrayList<>();

        for(int i = 1 ; i <= 30 ; i++){
            Flight f = new Flight(i);
            this.flights.add(f);
        }
    }

    public boolean bookTicket(User user, int flightNo){
        if(flightNo < 1 || flightNo > this.flights.size()){
            System.out.println("There is no existing flight on that number........");
            return false;
        }

        Flight f = this.flights.get(flightNo-1);
        
        if(f.checkAvailability()){
            String newTicketNo = this.getUniqueTicketNo();
            // System.out.println(newTicketNo);
            Ticket ticket = new Ticket(user.getName(),flightNo,f.getCost(),newTicketNo);
            System.out.println("Ticket Booked..... :) ");
            this.tickets.add(ticket);
            user.addTicket(ticket);
            f.addTicket(ticket);
            f.increaseSeat();
        }
        else{
            System.out.println("Sorry, all seats are filled :(");
        }

        return true;
    }

    public String getUniqueTicketNo(){
        Random rand = new Random();
        String newNo;
        boolean unique ;
        do{
            newNo = "";
            for(int i = 0 ; i < 8 ; i++){
                newNo += String.valueOf(rand.nextInt(10));
            }
            unique = false;
            for(Ticket t : this.tickets){
                if(t.getTicketNo().equals(newNo)){
                    unique = true;
                }
            }
        }while(unique);

        return newNo;
    }

    public User validateUser(String name , String password){
        for(User u : this.users){
            if(u.getName().equalsIgnoreCase(name) && u.getPassword().equalsIgnoreCase(password)){
                return u;
            }
        }
        return null;
    }

    public void createNewUser(String name , String password){
        for(User u : this.users){
            if(u.getName().equalsIgnoreCase(name)){
                System.out.printf("The user name '%s' is already exist.......\nTRY AGAIN.......",name);
                return;
            }
        }
        User user = new User(name, password);
        this.users.add(user);
    }

    public boolean cancelTicket(String ticketNo , User user){
        boolean ans = false;
        // System.out.println(this.tickets);

        for(int i = 0 ; i < this.tickets.size() ; i++){
            if(this.tickets.get(i).getTicketNo().equals(ticketNo)){
                this.tickets.remove(i);
                ans = true;
                break;
            }
        }
        // System.out.println(this.tickets);

        user.cancelTicket(ticketNo);
        return ans;
    }

    public void printAllFlights(){
        for(int i = 0 ; i < this.flights.size(); i++){
            Flight f = this.flights.get(i);
            System.out.printf("Flight No = %d : Total Capasity = %d : Booked Seats = %d : Ticket Cost = ₹%.02f\n",i+1,f.getTotalSeats(),f.getBookedSeats(),f.getCost());
        }
    }

}
