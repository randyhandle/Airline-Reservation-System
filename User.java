package AirlineReservationSystem;


import java.util.ArrayList;


public class User {
    private String name;
    private String password;
    private ArrayList<Ticket> tickets;

    public User(String name ,String password){
        this.name = name;
        this.password = password;
        this.tickets = new ArrayList<Ticket>();

        System.out.printf("New User %s is successfully created\n",this.name);
    }

    public void addTicket(Ticket t){
        this.tickets.add(t);
    }

    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return this.password;
    }

    public void cancelTicket(String ticketNo){
        for(int i = 0 ; i < this.tickets.size() ; i++){
            if(this.tickets.get(i).getTicketNo().equals(ticketNo)){
                this.tickets.remove(i);
            }
        }
    }
}
