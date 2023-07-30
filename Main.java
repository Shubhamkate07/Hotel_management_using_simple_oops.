import java.util.*;

class Room {
    Scanner sc = new Scanner(System.in);
    private int roomNumber;
    private String customer;
    double totalAmount=0;
    int roomprice=1000;
    int roomprice2 =2000;
    int roomprice3=4000;

    public void roomdetails() {
        System.out.println("Press Number from 1-3 to continue info of the room:");
        int choice1 = sc.nextInt();
        switch (choice1) {
            case 1:
                System.out.println("Single");
                System.out.println("Price- Rs "+roomprice);
                System.out.println("Ac - No");
                break;
            case 2:
                System.out.println("Double");
                System.out.println("Price- Rs "+ roomprice2);
                System.out.println("Ac - No");
                break;
            case 3:
                System.out.println("Luxury");
                System.out.println("Price- Rs "+roomprice3);
                System.out.println("Ac - Yes");
                System.out.println("Free Breakfast");
                break;
            default:
                System.out.println("Invalid data");
        }
    }

    public void Availability(int roomno) {
        if(roomno<4 || roomno==2  || roomno==3){
            
        System.out.println("Available");
    }
    else if(roomno>=4){
        System.out.println("Root does't Exit!!");
    }
    else 
    {
       System.out.println("Room not Available");
    }
    
    }

    public void roombook(int roomNumber, String customer) {
        this.roomNumber = roomNumber;
        this.customer = customer;
        System.out.println("The room no " + roomNumber + " booked by " + customer);
    }
    
    
    
    // order Food
    
    public void orderFood(int roomNumber) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n==========\n   Menu:  \n==========");
        String[] menuItems = { "Sandwich", "Pasta", "Noodles", "Coke" };
        double[] menuPrices = { 50, 60, 70, 30 };
        System.out.println("Item\tPrice");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(i + 1 + ". " + menuItems[i] + "\tRs." + menuPrices[i]);
        }

        int[] quantities = new int[menuItems.length];
        double[] amounts = new double[menuItems.length];

// double totalAmount=0;
        do {
            System.out.print("Enter item number (1-4): ");
            int itemNumber = sc.nextInt();
            if (itemNumber < 1 || itemNumber > menuItems.length) {
                System.out.println("Invalid item number. Try again.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            if (quantity <= 0) {
                System.out.println("Invalid quantity. Try again.");
                continue;
            }


             totalAmount += menuPrices[itemNumber - 1] * quantity;
            System.out.print("Do you want to order anything else? (y/n): ");
            sc.nextLine(); // Consume newline
            char wish = sc.nextLine().charAt(0);

            if (wish == 'n' || wish == 'N') {
                break;
            }
        }while(true);{
            System.out.println("your bill  .Rs"+totalAmount);
        }
    }
    
    
    
// total bill

public void totalbill( ){
    System.out.println("Sir which room");
    int romno=sc.nextInt();
    if(romno==1){
        double totalBil= roomprice+ totalAmount;
    System.out.println("Yor Total bill .Rs" + totalBil);
    System.out.println("===Thanks for Visit.===" +" ====Visit Again===");
    }
    else if(romno==2){
        double totalBil= roomprice2+ totalAmount;
    System.out.println("Yor Total bill .Rs" + totalBil);
    System.out.println("===Thanks for Visit.===" +" ====Visit Again===");
    }
    else if(romno==3){
        double totalBil= roomprice3+ totalAmount;
    System.out.println("Yor Total bill .Rs" + totalBil);
    System.out.println("===Thanks for Visit.===" +" ====Visit Again===");
    }
    
}
    
    
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         System.out.println("\n===== Hotel Management System =====");
        System.out.println("\n===Welcome to the Shubham Hotel. How may I help you!===");
        System.out.println("1. Display Room Details");
        System.out.println("2. Display Room Availability");
        System.out.println("3. Book Room");
        System.out.println("4. Order Food");
        System.out.println("5. Bill");
        Room ob = new Room();

        while (true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Display room Details ");
                    ob.roomdetails();
                    break;
                case 2:
                    System.out.println("Enter room from 1-5 ");
                    int roomno = sc.nextInt();
                    ob.Availability(roomno);
                    break;
                case 3:
                    System.out.println("Enter room No to book");
                    int no = sc.nextInt();
                    sc.nextLine(); // Consume the newline character left in the input buffer
                    System.out.print("Enter Name-");
                    String Naam = sc.nextLine();

                    ob.roombook(no, Naam);
                    break;
                    
                    
                    case 4:
                        System.out.println("Enter room Number");
                        int roomno1=sc.nextInt();
                        ob.orderFood(roomno1);
                        System.out.println("Thanks for Order.");
                        break;
                        
                    case 5:
                        // System.out.println("Enter room Number");
                        // int roomno2=sc.nextInt();
                        ob.totalbill();
                        break;
                default:
                    System.out.println("Invalid");
            }
        }
    }
}
