package machine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has: ");
        int waterSupply = scan.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milkSupply = scan.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int beansSupply = scan.nextInt();

        System.out.println("Write how many cups of coffee you will need: ");
        int cupsNeed = scan.nextInt();

        int cupsCanMake = howManyCups(waterSupply, milkSupply, beansSupply);

        if (cupsNeed == cupsCanMake) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsNeed > cupsCanMake) {
            System.out.printf("No, I can make only %d cup(s) of coffee\n", cupsCanMake);
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", cupsCanMake - cupsNeed);
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
