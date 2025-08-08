package cinema;
import java.util.Scanner;

public class Cinema {
    static Scanner reader = new Scanner(System.in);
    static String[][] seats;
    static int rows;
    static int cols;
    static boolean running = true;
    static int purchased = 0; 
	  static double percentage = 0;
	  static int ten = 0;
	  static int eight = 0;
    static int current = 0; 
	  static int total = 0;
    
    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        rows = reader.nextInt();
        System.out.println("Enter the number of seats in each row:");
        cols = reader.nextInt();   
        seats = new String[rows][cols];
        for (int i = 0; i < rows; i++) {   	
            for (int j = 0; j < cols; j++) {
                seats[i][j] = "S";
            }
        }
          
        while (running) { // boolean instead of System.exit(0); 
            menu();
        }       
    }
    
    public static void menu () {
        System.out.println("\n1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics"); 
        System.out.println("0. Exit");
        int number = reader.nextInt();
        switch (number) {
        	  case 1:
            		seatMap();
            		break;
        	  case 2:
            		buy();
            		break;
            case 3:
                stats();
                break;
            case 0:
                running=false;
                //System.exit(0);
        		return;
        }
    }

    public static void seatMap () { 
        System.out.println("Cinema:"); // header
        System.out.print("  ");
        for (int i = 1; i <= cols; i++) {
            System.out.print(i + " ");
        }
        System.out.println();                      
        for (int i = 0; i < rows; i++) { 
            System.out.print((i + 1) + " "); 
            for (int j = 0; j < cols; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void buy () {
        int bookedR, bookedS; 

        while (true) {			
            System.out.println("Enter a row number:"); 												
            bookedR= reader.nextInt();
            System.out.println("Enter a seat number in that row:");
            bookedS = reader.nextInt();
            
            if (bookedR < 1 || bookedR > rows || bookedS < 1 || bookedS > cols) { //Out of bound error
            System.out.println("Wrong input!");
            continue;
            }
                    
            if (seats[bookedR-1][bookedS-1].equals("B")) { // Check if seat is already booked
            System.out.println("That ticket has already been purchased!"); 
            continue;
            }
        
            break; // Seat is valid and available
    	}


        seats [bookedR-1][bookedS-1] = "B";  
        purchased++;
        
        double price; 
        if (cols*rows <= 60) {
            price = 10;
		        ten++;
        } else if (bookedR <= rows/2) {
            price =  10; 
		        ten++;
        } else {
            price = 8;
		        eight++;
        }    
        System.out.println("Ticket price: $" + price);
    }

    public static void stats () {
        percentage = (double)purchased / (rows * cols) * 100; // cast to double
        current = ten*10 + eight*8;
      	if (cols*rows <= 60) {
            total = cols*rows*10;
        } else {
            total =  (rows/2)*cols*10 + (rows - rows/2)*cols*8;
        }        
    	  System.out.println("Number of purchased tickets: " + purchased); 
        System.out.printf("Percentage: %.2f%%\n", percentage); 
        System.out.println("Current income: $" + current);
        System.out.println("Total income: $" + total); 
    }
}
