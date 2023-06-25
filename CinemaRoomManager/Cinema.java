package cinema;
import java.util.Arrays;
import java.util.Scanner;
public class Cinema {

    public static Scanner scanner = new Scanner(System.in); // dlaczego musze definiowac tak na wstepie te poniższe?
    public static int rows;
    public static int chosenRow;
    public static int choose;
    public static int seats;
    public static int price;
    public static int chosenSeat;
    public static int currentIncome = 0;
    public static int qtyTicket = 0;
    //public static int price;

    public static String [][] defaultSeats;;


    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();
        defaultSeats = new String[rows + 1][seats + 1];
        makeSeats();
        printMenu();
    }

    public static void printMenu() {
        System.out.println("\n" + "1. Show the seats\n" + "2. Buy a ticket\n"+ "3. Statistics\n" + "0. Exit");
        choose = scanner.nextInt();
        boolean isRunning = true;
        //while (isRunning) {
            switch (choose) {
                case 1:
                    showSeats();
                    printMenu();
                case 2:
                    chooseSeats();
                    printMenu();
                case 3:
                    Statistic ();
                    printMenu();
                case 0:
                    //System.exit(0);
                    break;
            }
        //}
    }
    public static String [][] makeSeats () {
        for (int i = 0; i < rows + 1 ; i++){
            for (int j = 0; j < seats + 1; j++){
                defaultSeats [i][j] = i == 0 ? (j == 0 ? " " : String.valueOf(j)) : j == 0 ? String.valueOf(i) : "S";
            }
        }
        return defaultSeats;
    }

    public static void showSeats () {
        System.out.println("Cinema:");
        for (int i = 0; i < rows + 1 ; i++){
            for (int j = 0; j < seats + 1; j++){
                System.out.print(defaultSeats [i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void chooseSeats () {
        System.out.println("\n" + "Enter a row number:");
        chosenRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        chosenSeat = scanner.nextInt();
        checkBounds();
        checkIfPurchesed();
        modifySeats();
        calculatePrice ();
        countQtyTickets();
        countIncome ();
    }
    public static void checkBounds () {
        if (chosenRow < 1 || chosenRow > ( defaultSeats.length - 1) || chosenSeat < 1 || chosenSeat > (defaultSeats[rows].length - 1) ) {
            System.out.println("Wrong input!");
            chooseSeats();
        }
    }
    public static int countQtyTickets () {
        qtyTicket += 1;
        return qtyTicket;
    }
    public static int countIncome () {
        currentIncome += price;
        return currentIncome;
    }

    public static void Statistic () {
        int allSeats = rows * seats;
        int frontSeats = rows/2 * seats;
        int backSeats = (rows - rows/2) * seats;
        float percentage = (float) qtyTicket / allSeats * 100;
        int totalIncome = rows * seats <= 60 ? (10 * allSeats) : (( 10 * frontSeats) + (8 * backSeats));
        System.out.println("Number of purchased tickets: " + qtyTicket);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }

    public static void checkIfPurchesed () {
        if (defaultSeats [chosenRow][chosenSeat].equals ("B")) {
            System.out.println("That ticket has already been purchased!");
            chooseSeats();
        }
    }

    //public static void printPrice () {
        //System.out.println("Ticket price: $" + calculatePrice ());
    //}

    public static String [][] modifySeats () {
        defaultSeats[chosenRow][chosenSeat] = "B";
        return defaultSeats;
    }


    public static int calculatePrice () {
        int front = rows / 2; // w jakim miejscu definiwoac front, zeby mozna było użyc tej zmiennej tez w innej metodzie?
        price = rows * seats <= 60 ? 10 : chosenRow <= front ? 10 : 8;
        System.out.println("Ticket price: $" + price);
        return price;

    }

}