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

        while (true) {
            System.out.println("The coffee machine has:");
            System.out.printf("%d ml of water", water);
            System.out.printf("%d ml of milk", milk);
            System.out.printf("%d g of coffee beans", beans);
            System.out.printf("%d disposable cups", disposableCups);
            System.out.printf("$%d of money", money);

            System.out.println("Write action (buy, fill, take):");
            String action = scan.nextLine();

            switch (action) {
                case "bue": {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                    // метод покупки кофе
                    break;
                }
                case "fill": {
                    System.out.println("Write how many ml of water you want to add:");
                    water += scan.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    milk += scan.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    beans += scan.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    disposableCups += scan.nextInt();
                    break;
                }
                case "take": {
                    System.out.printf("I gave you $%d", money);
                    money = 0;
                     break;
                }
            }
        }

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
