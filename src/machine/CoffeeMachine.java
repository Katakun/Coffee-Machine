package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int water = 400;
        int milk = 540;
        int beans = 120;
        int disposableCups = 9;
        int money = 550;

        boolean isExit = false;

        while (!isExit) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
            String action = scan.nextLine();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                    int choice = scan.nextInt();
                    switch (choice) {

                        case 1:
                            if (water >= 250 && beans >= 16 && disposableCups >= 1) {
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= 250;
                                beans -= 16;
                                money += 4;
                                disposableCups--;
                            } else {
                                System.out.println("Sorry, not enough water!");
                            }
                            break;

                        case 2:
                            if (water >= 350 && milk >= 75 && beans >= 20 && disposableCups >= 1) {
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= 350;
                                milk -= 75;
                                beans -= 20;
                                money += 7;
                                disposableCups--;
                            } else {
                                System.out.println("Sorry, not enough water!");
                            }
                            break;

                        case 3:
                            if (water >= 200 && milk >= 100 && beans >= 12 && disposableCups >= 1) {
                                System.out.println("I have enough resources, making you a coffee!");
                                water -= 200;
                                milk -= 100;
                                beans -= 12;
                                money += 6;
                                disposableCups--;
                            } else {
                                System.out.println("Sorry, not enough water!");
                            }
                            break;
                    }
                    break;

                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    water += scan.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    milk += scan.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    beans += scan.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    disposableCups += scan.nextInt();
                    break;

                case "take":
                    System.out.printf("I gave you $%d\n", money);
                    money = 0;
                    break;

                case "remaining":
                    cofeeMachineStatus(water, milk, beans, disposableCups, money);
                    break;

                case "exit":
                    isExit = true;
                    break;
            }
        }
    }

    public static void cofeeMachineStatus(int water, int milk, int beans, int disposableCups, int money) {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water", water);
        System.out.printf("\n%d ml of milk", milk);
        System.out.printf("\n%d g of coffee beans", beans);
        System.out.printf("\n%d disposable cups", disposableCups);
        System.out.printf("\n$%d of money\n", money);
    }

    public static void howManyIngredients(int cupsOfCoffee) {
        final int WATER = 200;
        final int MILK = 50;
        final int BEANS = 15;
        System.out.printf("For %d cups of coffee you will need:\n", cupsOfCoffee);
        System.out.printf("%d ml of water\n", cupsOfCoffee * WATER);
        System.out.printf("%d ml of milk\n", cupsOfCoffee * MILK);
        System.out.printf("%d g of coffee beans\n", cupsOfCoffee * BEANS);

    }

    public static int howManyCups(int waterSupply, int milkSupply, int beansSupply) {
        final int WATER = 200;
        final int MILK = 50;
        final int BEANS = 15;

        int cupOfWater = waterSupply / WATER;
        int cupOfMilk = milkSupply / MILK;
        int cupOfBeans = beansSupply / BEANS;

        return smallestNumber(cupOfBeans, cupOfMilk, cupOfWater);
    }

    public static int smallestNumber(int num1, int num2, int num3) {
        if (num1 < num2 && num1 < num3) {
            return num1;
        } else if (num2 < num1 && num2 < num3) {
            return num2;
        } else {
            return num3;
        }
    }
}
