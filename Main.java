/**
 *  The function of this program is to create and modify an object "coffee" and make it
 *  easy to customise by the user
 *  CS108-1
 *  6/30/2022
 *  @author  Mohammed Alsharif
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

    Scanner CafeApplication = new Scanner(System.in);
        System.out.println("Cafe Application Running...");
        int input = 0;
        while (input != 1){
            System.out.println("\nPress 1 : Read Inventory\nPress 2 : Create Coffee Order\n" +
                    "Press 3 : Update Inventory\nPress 4 : Update log file\nPress 5 : Exit the application\n");
            switch (CafeApplication.nextLine()){
                case "1":
                    System.out.println("Current items in the inventory:");
                    BufferedReader br = new BufferedReader(new FileReader("Inventory.txt"));
                    String line1;
                    while ((line1 = br.readLine()) != null) {
                        System.out.println(line1);
                    }
                    break;
                case "2":
                    ArrayList<String> Item = new ArrayList<>();
                    ArrayList<Double> price = new ArrayList<>();
                    ArrayList<String> Temp2 = new ArrayList<>();
                    Scanner userOrders = new Scanner(System.in);
                    System.out.println("Coffee order created. Select toppings for the first coffee:");
                    String line = "yes" ;
                    do
                    {
                        BasicCoffee coffee = new BasicCoffee();
                        Item.add(coffee.printCoffee());
                        price.add(coffee.cost());
                        PrintOrder(Item, price);
                        System.out.println("Do you want to add another coffee to this order? - yes or no");
                    }while (!(line = userOrders.nextLine()).equals("no"));
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    input = 1;
                    break;
                default:
                    System.out.println("Invalid Selection. Please Try Again");
            }
        }
        Stack<String> stack = new Stack<String>();

    }

    /**
     * Takes in an "Item" and a "price" and prints out the details of the order.
     * @param Item
     * @param price
     * @return
     */
    public static String PrintOrder(ArrayList<String> Item, ArrayList<Double> price){
        int numItems = Item.size();
        int i;
        double totPrice = 0.0;
        StringBuilder str = new StringBuilder();
        for (i = 0; i < numItems; i++){
            str.append("Item " + (i+1) +": " + Item.get(i) + " | cost:" + price.get(i) + "\n");
        }
        for (i = 0; i < numItems; i++){
            totPrice = totPrice + price.get(i);
        }
            str.append("\nTOTAL COST OF ORDER:" + totPrice);

        System.out.println(str.toString());
        return str.toString();
    }
    /**
     * Creates a BasicCoffee object that is then modified and edited and stores
     * information about the order by calling other methods
     */
    public static ArrayList<String> CreateOrder() {
        Scanner userFeedback = new Scanner(System.in);
        ArrayList<String> coffeeOrder = new ArrayList<String>();
        Coffee basicCoffee = new BasicCoffee();
        int in = 0;
        while (in != 1) {
            System.out.println("Enter the following values to add toppings: 1.) milk, 2.) " +
                    "hot water, 3.) espresso, 4.) sugar, 5) whipped cream, e - to complete order");
            switch (userFeedback.nextLine()) {
                case "1":
                    basicCoffee = new Milk(basicCoffee);
                    break;
                case "2":
                    basicCoffee = new HotWater(basicCoffee);
                    break;
                case "3":
                    basicCoffee = new Espresso(basicCoffee);
                    break;
                case "4":
                    basicCoffee = new Sugar(basicCoffee);
                    break;
                case "5":
                    basicCoffee = new WhippedCream(basicCoffee);
                    break;
                case "e":
                    in = 1;
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
        return coffeeOrder;
    }
}
