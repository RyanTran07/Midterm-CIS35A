import java.util.Scanner;

public class Order {

    // Array variables
    private final int arrSize = 5;
    private String[] burgerNames = {"De Anza Burger", "Bacon Cheese", "Mushroom Swiss", "Western Burger", "Don Cali Burger"};
    private int[] orderArr = {0, 0, 0, 0, 0};
    private final double[] priceArr = {5.25, 5.75, 5.95, 5.95, 5.95};

    // customerType = 1 (student) customerType = 2 (staff)
    private int customerType;

    // Instance variables relating to money/calculations
    private double subTotal;
    private double total;
    private double tax;
    Scanner input = new Scanner(System.in);


    public Order() {
        this.customerType = -1;
        this.subTotal = 0.0;
        this.total = 0.0;
        this.tax = 0.0;
    }

    public void displayMenu() {

        for(int i = 0; i < arrSize; i++) {
            System.out.println((i+1) + ". " + burgerNames[i] + "- $" + priceArr[i]);
        }

    }


    public boolean orderArrEmpty() {
        for(int i = 0; i < arrSize; i++) {
            if(orderArr[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public void getInputs() {
        boolean orderEnded = false;

        int userBurgerSelection = -1;
        int userQuantity = -1;

        while(!orderEnded) {
            displayMenu();
            System.out.print("Please enter a burger option (1-5), or select 6 to exit: ");
            userBurgerSelection = input.nextInt();


            // Input validation for the burger selection
            while(userBurgerSelection < 1 || userBurgerSelection > 6) {
                System.out.print("Please enter a valid burger selection (1-5), or exit (6): ");
                userBurgerSelection = input.nextInt();
            }

            // If the user ends the order, end the while loop
            if(userBurgerSelection == 6) {
                System.out.println("Your order has now ended.");
                orderEnded = true;
                continue;
            }

            // Collecting input
            System.out.print("Please enter the number of " + burgerNames[userBurgerSelection - 1] + "that you would like to order: " );
            userQuantity = input.nextInt();

            // Input validation for the amount of burgers to order
            while(userQuantity < 0) {
                System.out.print("Please enter a valid (non-negative) number of burgers to order: ");
                userQuantity = input.nextInt();
            }


            switch(userBurgerSelection) {
                case 1:
                    orderArr[0] += userQuantity;
                    break;
                case 2:
                    orderArr[1] += userQuantity;
                    break;
                case 3:
                    orderArr[2] += userQuantity;
                    break;
                case 4:
                    orderArr[3] += userQuantity;
                    break;
                case 5:
                    orderArr[4] += userQuantity;
                    break;

            }


            System.out.println("1. Student\n2.Staff");
            System.out.print("Please enter the type of customer you are: ");

            customerType = input.nextInt();

            while(customerType < 1 || customerType > 2) {
                System.out.print("Please choose a valid customer type (1-2): ");
                customerType = input.nextInt();
            }


        }


    }

    public void printBill() {

        for (int i = 0; i < arrSize; i++) {
            if (orderArr [i] > 0) {
                System.out.println(orderArr [i] + " " + burgerNames [i] + ": $" + String.format("%.2f", orderArr[i]*priceArr[i]));
            } else {
                continue;
            }
        }
        System.out.printf("The total before tax is: $%.2f%n", subTotal);
        System.out.printf("The tax amount is: $%.2f%n", tax);
        System.out.printf("The total bill is: $%.2f%n", total);

    }

    public void calculate() {
        for (int i = 0; i < arrSize; i++) {
            subTotal += priceArr[i] * orderArr[i];
        }

        if (customerType == 2) {
            tax = subTotal * .09;
            total = subTotal + tax;
        }

        else if (customerType == 1) {
            total = subTotal;
        }

    }

}
