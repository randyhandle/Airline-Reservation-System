package AirlineReservationSystem;


import java.util.Random;


public class Ticket {
    private String holder; 
    private int flightNo;
    private String ticketNo;
    private int seatNo;
    private double cost;

    public Ticket(String name ,int flightNo,double cost , String ticketNo){
        Random rand = new Random();
        this.holder = name;
        this.flightNo = flightNo;
        this.seatNo = rand.nextInt(30) + 1;
        this.cost = cost;
        this.ticketNo = ticketNo;

        this.printDetails();
    }

    public void printDetails(){
        System.out.printf("\nTICKET's DETAILS........\nTicket Holder Name : %s\nTicket No : %s\nFlight No : %d\nSeat No : %d\n\n",this.holder , this.ticketNo , this.flightNo,this.seatNo);
    }

    public String getTicketNo(){
        return this.ticketNo;
    }



}
