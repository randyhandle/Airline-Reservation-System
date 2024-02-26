package AirlineReservationSystem;


import java.util.Scanner;


public class AirlineReservationSystem {
    public static void main(String[] args){
        Airline airline = new Airline();
        Scanner scan = new Scanner(System.in);

        while(true){
            int outerChoice;
            do{
                System.out.println("\nWelcome to Airline Reseravation System :)\n");
                System.out.println("1. Log in\n2. Create new user");
                System.out.print("Enter your option : ");
                outerChoice = scan.nextInt();
                if(outerChoice < 0 || outerChoice > 2){
                    System.out.println("Invalid Option.......\nTRY AGAIN........\n");
                }
            }while(outerChoice < 0 || outerChoice > 2);
            scan.nextLine();

            switch(outerChoice){
                case 1:
                    User user = AirlineReservationSystem.checkUser(airline,scan);
                    AirlineReservationSystem.logIn(scan,airline,user);
                    break;
                case 2:
                    AirlineReservationSystem.createUser(scan,airline);
                    break;
            }
            
        }
    }

    public static void logIn(Scanner scan , Airline airline,User user){
        
        int choice ;

        do{
            System.out.printf("\nWelcome %s , What operation do you wants to perform ?",user.getName());
            System.out.println("\n1. Book Ticket\n2. Cancel Ticket\n3. Show All Flight Details\n4. Exit\n");
            System.out.print("Enter your choice : ");
            choice = scan.nextInt();
            if(choice < 1 || choice > 4){
                System.out.println("Invalid option.........\nTRY AGAIN.........");
            }
        }while(choice < 1 || choice > 4);
        scan.nextLine();

        switch(choice){
            case 1:
                AirlineReservationSystem.bookTicket(airline,user,scan);
                break;
            case 2:
                AirlineReservationSystem.cancelTicket(airline,user,scan);
                break;
            case 3:
                AirlineReservationSystem.showAllFlightDetails(airline);
                break;
            case 4:
                return;
        }
        if(choice > 0 && choice < 4){
            AirlineReservationSystem.logIn(scan, airline,user);
        }
    }


    public static void createUser(Scanner scan, Airline airline){
        String name;
        String password;
        System.out.print("Enter the User Name : ");
        name = scan.nextLine();
        System.out.print("Enter the Password : ");
        password = scan.nextLine();

        airline.createNewUser(name,password);
    }

    public static User checkUser(Airline airline , Scanner scan){
        User user;
        do{
            System.out.print("Enter the User Name : ");
            String name = scan.nextLine();
            System.out.print("Enter the password : ");
            String password = scan.nextLine();
            user = airline.validateUser(name,password);
            if(user == null){
                System.out.println("Invalid User name or Password!!!!\nTRY AGAIN......\n");
                // AirlineReservationSystem.checkUser(airline,scan);
            }
        }while(user == null);
        return user;
    }

    public static void bookTicket(Airline airline , User user , Scanner scan){
        int flightNo ;
        boolean booked;
        do{
            System.out.print("Enter the Flight No : ");
            flightNo = scan.nextInt();

            booked = airline.bookTicket(user, flightNo);
        }while(!booked);
        scan.nextLine();
    }

    public static void cancelTicket(Airline airline , User user , Scanner scan){
        String ticketNo;
        boolean removed ;

        do{
            System.out.print("Enter the Ticket No : ");
            ticketNo = scan.nextLine();

            removed = airline.cancelTicket(ticketNo , user);
            if(removed == false){
                System.out.println("Entered Ticket Number is Incorrect.........\nTRY AGAIN.........\n");
            }
        }while(!removed);

        System.out.println("Ticket Canceled Successfully....... :(");
    }

    public static void showAllFlightDetails(Airline airline){
        airline.printAllFlights();
    }

}
