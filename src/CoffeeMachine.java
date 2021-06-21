package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int water=400;
        int milk=540;
        int coffee_beans=120;
        int cups=9;
        int money=550;
        String action=" ";
        while(action!="exit"){
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action=scanner.nextLine();
            switch (action){
                case "buy":
                    System.out.println("1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    String choice=scanner.nextLine();
                    switch(choice){
                        case "1":
                            if(water>=250&&coffee_beans>=16)
                            {
                                water -=250;
                                coffee_beans -= 16;
                                money +=4;
                                cups -=1;
                                System.out.println("I have enough resources, making you a coffee!");
                            }
                            else {
                                if(water<250) System.out.println("Sorry, not enough water!");
                                else if (coffee_beans<16) System.out.println("Sorry, not enough coffee beans!");
                            }
                            break;
                        case "2":
                            if(water>=350&&milk>=75&&coffee_beans>=20) {
                                water -=350;
                                coffee_beans -= 20;
                                milk -=75;
                                money +=7;
                                cups -=1;
                                System.out.println("I have enough resources, making you a coffee!");
                            }
                            else {
                                if(water<350) System.out.println("Sorry, not enough water!");
                                if (coffee_beans<20) System.out.println("Sorry, not enough coffee beans!");
                                if (milk<75) System.out.println("Sorry, not enough milk!");
                            }
                            break;
                        case "3":
                            if(water>=200 && milk>=100 && coffee_beans>=12) {
                                water -=200;
                                coffee_beans -= 12;
                                milk -=100;
                                money +=6;
                                cups -=1;
                                System.out.println("I have enough resources, making you a coffee!");
                            }
                            else {
                                if(water<200) System.out.println("Sorry, not enough water!");
                                if (coffee_beans<12) System.out.println("Sorry, not enough coffee beans!");
                                if (milk<100) System.out.println("Sorry, not enough milk!");
                            }
                            break;
                        case "back":
                            break;
                        default:
                            break;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add: ");
                    int water_add=scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    int milk_add=scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add: ");
                    int coffee_beans_add=scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add: ");
                    int cups_add=scanner.nextInt();

                    water +=water_add;
                    milk +=milk_add;
                    coffee_beans +=coffee_beans_add;
                    cups +=cups_add;
                    break;
                case "take":
                    System.out.println("I gave you $"+money);
                    money=0;
                    break;
                case "remaining" :
                    afficher_ingredients(water,milk,coffee_beans,cups,money);
                    break;
                case "exit":
                    System.exit(0);
                    break;
            }
        }
    }

    public static void afficher_menu(){
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }

    public static void afficher_needed(int cups, int water, int milk, int coffee_beans){
        System.out.println("For "+cups+" cups of coffee you will need:");
        System.out.println(water+" ml of water");
        System.out.println(milk+" ml of milk");
        System.out.println(coffee_beans+" g of coffee beans");
    }

    public static void request_coffee(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water_have=scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk_have=scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffee_beans_have=scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int cups=scanner.nextInt();
        int water_needed=cups*200;
        int milk_needed=cups*50;
        int coffee_beans_needed=cups*15;

        int water_result=water_have/200;
        int milk_result=milk_have/50;
        int coffee_beans_result=coffee_beans_have/15;
        int min = Math.min(Math.min( coffee_beans_result, milk_result),water_result );

        if(min<cups){
            System.out.println("No, I can make only "+ min +" cup(s) of coffee");
        }
        else if (min==cups){
            System.out.println("Yes, I can make that amount of coffee");
        }
        else{
            System.out.println("Yes, I can make that amount of coffee (and even "+ (min-cups)+" more than that)");
        }
    }

    public static void afficher_ingredients(int water,int milk,int coffee_beans,int cups,int money){
        System.out.println("The coffee machine has:");
        System.out.println(water+" ml of water");
        System.out.println(milk+" ml of milk");
        System.out.println(coffee_beans+" g of coffee beans");
        System.out.println(cups+" disposable cups");
        System.out.println("$"+money+" of money");
    }

}