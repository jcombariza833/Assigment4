import receipts.Receipt;

import java.util.Scanner;

public class UserInterface {
    boolean running = true;
    SystemInterface system = new SystemInterface();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        principalMenu();
        while (running) {

            displayMenuOptionInput();
            int menuOption = validateIntInput(scanner,1,4);

            switch (menuOption) {
                case 1:
                    System.out.println("\nLIST OF PRODUCTS IN THE STORE\n");
                    display(system.startNewReceipt());
                    separator();
                    break;
                case 2:
                    displayAddItemInput();
                    int itemNumber = validateIntInput(scanner,1,system.getStoredItemsSize());
                    system.addItem(itemNumber);
                    separator();
                    break;
                case 3:
                    Receipt receipt = system.getReceipt();
                    receipt.prtReceipt();
                    separator();
                    break;
                case 4:
                    running = false;
                    break;
            }
        }
    }

    private void display(String[] lines) {
        for (String line: lines) {
            System.out.println(line);
        }
    }

    private void principalMenu() {
        System.out.println("PRINCIPAL MENU\n");
        System.out.println(
                        "\t1 - Start New Receipt\n"+
                        "\t2 - Add Items\n"+
                        "\t3 - Display Receipt\n"+
                        "\t4 - Quit\n");
    }

    private void  displayMenuOptionInput() {
        System.out.print("Please choose an option from the principal menu: ");
    }

    private void  displayAddItemInput() {
        System.out.print("Insert the number of the item to be added: ");
    }

    private void separator() {
        System.out.println("-".repeat(70));
    }

    private int validateIntInput(Scanner input, int min, int max) {
        int menuOption = validateIntInputType(input);

        if (menuOption < min || menuOption > max) {
            System.out.print("This option is not in the menu.\n" + "Please choose an option: ");
            menuOption = validateIntInput(input, min, max);
        }
        return menuOption;
    }

    private int validateIntInputType(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("That is not a valid input, please try again.\n" + "Please choose an option: ");
            input.next();
        }

        return input.nextInt();
    }
}
