import java.util.Scanner;

public class Order {

    // Array instance variables
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


    /*
     * boolean orderArrEmpty()
     *
     *
     */
    public boolean orderArrEmpty() {
        for(int i = 0; i < arrSize; i++) {
            if(orderArr[i] != 0) {
                return false;
            }
        }

        return true;
    }

    /*
     * void getInputs()
     *  Purpose: Collect user input on what burgers should be ordered, how many
     *           of each burger should be collected, and the type of customer
     *           the user is.
     *
     *  Receives: N/A
     *  Returns: N/A
     *  Output: N/A
     *
     */
    public void getInputs() {
        boolean orderEnded = false;

        int userBurgerSelection = -1;
        int userQuantity = -1;

        while(!orderEnded) {
            displayMenu();
            System.out.print("Please enter a burger option (1-5), or select 6 to exit: ");

            // Input validation for the burger selection
            while (true) {
            	if (input.hasNextInt()) {
            		userBurgerSelection = input.nextInt();
            		if (userBurgerSelection <=6 && userBurgerSelection >= 1) {
            			break;
            		} else {
            			System.out.print("Invalid Selection. Please choose a burger by entering a number from 1-5: ");
            		}
            	} else {
            		input.next();
            		System.out.print("Invalid Selection. Please choose a burger by entering a number from 1-5: ");
            	}
            }


            // If the user ends the order, end the while loop
            if(userBurgerSelection == 6) {
                System.out.println("Your order has now ended.");
                orderEnded = true;
                continue;
            }

            // Collecting input
            System.out.print("Please enter the number of " + burgerNames[userBurgerSelection - 1] + "that you would like to order: " );


            // Input validation for the amount of burgers to order

            while (true) {
            	if (input.hasNextInt())  {
            		userQuantity = input.nextInt();
            		if (userQuantity>=0) {
            			break;
            		} else {
            			System.out.print("Please enter a valid amount of burgers to order: ");
            		}
            	} else {
            		input.next();
            		System.out.print("Please enter a valid amount of burgers to order: ");
            	}
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


            while (true) {
            	if (input.hasNextInt()) {
            		customerType = input.nextInt();
            		if (customerType <= 2 && customerType >=1) {
            			break;
            		} else {
            			System.out.print("Please enter a valid customer type. 1 for student or 2 for staff: ");
            		}
            	} else {
            		input.next();
            		System.out.print("Please enter a valid customer type. 1 for student or 2 for staff: ");
            	}
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
