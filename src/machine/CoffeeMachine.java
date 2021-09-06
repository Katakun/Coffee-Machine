package machine;

import java.util.Scanner;

public class CoffeeMachine {
    int water;
    int milk;
    int beans;
    int disposableCups;
    int money;

    public void makeAction(String action) {
        switch (action) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                remaining();
                break;
        }
    }

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.disposableCups = 9;
        this.money = 550;
    }

    public void remaining() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water", this.water);
        System.out.printf("\n%d ml of milk", this.milk);
        System.out.printf("\n%d g of coffee beans", this.beans);
        System.out.printf("\n%d disposable cups", this.disposableCups);
        System.out.printf("\n$%d of money\n", this.money);
    }

    public void take() {
        System.out.printf("I gave you $%d\n", this.money);
        money = 0;
    }

    public void fill() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Write how many ml of water you want to add:");
        this.water += scan.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        this.milk += scan.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        this.beans += scan.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add:");
        this.disposableCups += scan.nextInt();
    }

    public void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        switch (choice) {
            case "1":
                if (this.water >= 250 && this.beans >= 16 && this.disposableCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 250;
                    this.beans -= 16;
                    this.money += 4;
                    this.disposableCups--;
                } else {
                    String missingIngredient = this.water < 250 ? "water" : this.beans < 16 ? "beans" : "disposableCups";
                    System.out.printf("Sorry, not enough %s!", missingIngredient);
                }
                break;
            case "2":
                if (this.water >= 350 && this.milk >= 75 && this.beans >= 20 && this.disposableCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 350;
                    this.milk -= 75;
                    this.beans -= 20;
                    this.money += 7;
                    this.disposableCups--;
                } else {
                    String missingIngredient = this.water < 350 ? "water" : this.beans < 20 ? "beans" : this.disposableCups < 1 ? "disposableCups" : "milk";
                    System.out.printf("Sorry, not enough %s!", missingIngredient);
                }
                break;
            case "3":
                if (this.water >= 200 && this.milk >= 100 && this.beans >= 12 && this.disposableCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 200;
                    this.milk -= 100;
                    this.beans -= 12;
                    this.money += 6;
                    this.disposableCups--;
                } else {
                    String missingIngredient = this.water < 200 ? "water" : this.beans < 12 ? "beans" : this.disposableCups < 1 ? "disposableCups" : "milk";
                    System.out.printf("Sorry, not enough %s!", missingIngredient);
                }
                break;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CoffeeMachine cm = new CoffeeMachine();

        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
            String action = scan.nextLine();
            if (action.equals("exit")) { break; }
            cm.makeAction(action);
        }
    }
}