package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static int totalWater;
    public static int totalMilk;
    public static int totalBeans;
    public static int totalCups;
    public static int totalMoney;

    public static int usedWater;
    public static int usedMilk;
    public static int usedBeans;
    public static int usedCups;
    public static int earnedMoney;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        totalWater = 400;
        totalMilk = 540;
        totalBeans = 120;
        totalCups = 9;
        totalMoney = 550;
        giveAction ();
        }

        public static void giveAction () {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        String action = input.nextLine();
        switch (action){
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                String chosenType = input.nextLine();
                usedCups = -1;
                switch (chosenType){
                    case "1":
                        usedWater = -250;
                        usedMilk = 0;
                        usedBeans = -16;
                        earnedMoney = 4;
                        updateTotal();
                        updateMoney();
                        break;
                    case "2":
                        usedWater = -350;
                        usedMilk = -75;
                        usedBeans = -20;
                        earnedMoney = 7;
                        updateMoney();
                        updateTotal();
                        break;
                    case "3":
                        usedWater = -200;
                        usedMilk = -100;
                        usedBeans = -12;
                        earnedMoney = 6;
                        updateMoney();
                        updateTotal();
                        break;
                    case "back":
                        giveAction();
                }
                break;
            case "fill":
                System.out.println("Write how many ml of water you want to add: ");
                usedWater = input.nextInt();
                System.out.println("Write how many ml of milk you want to add: ");
                usedMilk = input.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add: ");
                usedBeans = input.nextInt();
                System.out.println("Write how many disposable cups you want to add:");
                usedCups = input.nextInt();
                input.nextLine();
                updateTotal();
                break;
            case "take":
                System.out.println("I gave you $" + totalMoney + "\n");
                totalMoney = 0;
                break;
            case "remaining":
                printingTotal();
                break;
            case "exit":
                System.exit(0);
        }
        giveAction ();

    }
    public static void updateTotal() {

        int[] res = {totalWater, totalMilk, totalBeans, totalCups};
        int[] used = {usedWater, usedMilk, usedBeans, usedCups};
        String [] products = {"water", "milk", "beans","cups"};
        boolean allOk = true;
        for (int i = 0; i < res.length; i++){
            if (res[i] + used[i] < 0) {
                allOk = false;
                totalMoney -= earnedMoney;
                String productNok = products[i];
                System.out.println("Sorry, not enough " + productNok + "!");
                break;
            }
        }
        if (allOk){
            System.out.println("I have enough resources, making you a coffee!");
            //totalMoney += earnedMoney; gdzie to wrzucić, zeby naliczało się tylko przy buy
            totalWater = res[0] + used [0];
            totalMilk = res[1] + used [1];
            totalBeans= res[2] + used [2];
            totalCups = res[3] + used [3];

        }

    }
    public static void updateMoney(){
        totalMoney += earnedMoney;
    }
    public static void printingTotal() {
        System.out.printf("\nThe coffee machine has:%n%d ml of water%n%d ml of milk %n" +
                "%d g of coffee beans%n%d disposable cups%n$%d of money%n%n", totalWater, totalMilk, totalBeans, totalCups, totalMoney);
    }*/

}
