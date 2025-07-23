/*
 * Name: Ryan Tran, Krish Kowkuntla, Erin Law
 *
 * Description: This program is a menu-driven interaction system where a user
 *              continuosly enters their burger choice and how many burgers
 *              they want until they indicate that they want to end their order.
 *              It then asks them for what type of customer they are and prints
 *              out their order quantity, the subtotal for each burger option,
 *              their subtotal for all burgers, the tax charged, and the total
 *              bill.
 *
 */

public class Driver {
    public static void main(String[] args) {
        // Creating the Order object and calling all methods
        Order order1 = new Order();

        order1.displayMenu();
        order1.getInputs();
        order1.calculate();
        order1.printBill();
    }
}

/*
    Sample Output 1:

 */
