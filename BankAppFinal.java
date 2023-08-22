import java.util.Scanner;


public class BankAppFinal{
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CLEAR = "\033[H\033[2J";
    private static final String COLOR_BLUE_BOLD = "\033[34;1m";
    private static final String COLOR_RED_BOLD = "\033[31;1m";
    private static final String COLOR_GREEN_BOLD = "\033[33;1m";
    private static final String RESET = "\033[0m";
    private static final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
    private static final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);
    private static final String DASHBOARD = "👷 Welcome To Smart Banking System";
    private static final String ADD_ACCOUNT = "➕ Add New Account";
    private static final String DEPOSIT = "➕ Deposit";

    private static String[][] customers = new String[0][];

    public static void main(String[] args) {

        String screen = DASHBOARD;
        System.out.println(CLEAR);

        do {
            final String APP_TITLE = String.format("%s%s%s",
                    COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("\t" + APP_TITLE + "\n");

            switch (screen) {
                case DASHBOARD:

                    System.out.println("\t[1]. Open New Account");
                    System.out.println("\t[2]. Deposit Money");
                    System.out.println("\t[3]. Withdraw Money");
                    System.out.println("\t[4]. Transfer Money");
                    System.out.println("\t[5]. Check Account Balance");
                    System.out.println("\t[6]. Drop Existing Account");
                    System.out.println("\t[7]. Exit");
                    System.out.print("\tEnter an option to continue: ");

                    int option = SCANNER.nextInt();
                    System.out.println(CLEAR);
                    SCANNER.nextLine();
                    System.out.println(ADD_ACCOUNT);

                    switch (option) {
                        case 1:
                            screen = addAccount(customers);
                            break;
                        case 2:
                            screen = depositMoney(customers);
                            break;
                    }

            }
        } while (true);
    }

private static String addAccount(String[][] customers) {

        int id = customers.length + 1;
        String AcId = String.format("SDB-%05d", id);
        String name;
        Double deposit;
        boolean valid;

        do {
            String screen = ADD_ACCOUNT;
            valid = true;
            System.out.println();
            System.out.print("\tEnter A/C Name: ");
            name = SCANNER.nextLine().strip();
            if (name.isBlank()) {
                System.out.printf(ERROR_MSG, "A/C name can't be empty");
                valid = false;
                continue;
            }
            for (int i = 0; i < name.length(); i++) {
                if (!(Character.isLetter(name.charAt(i)) ||
                        Character.isSpaceChar(name.charAt(i)))) {
                    System.out.printf(ERROR_MSG, "Invalid A/C name");
                    valid = false;
                    break;
                }
            }
        } while (!valid);

        do {
            valid = true;
            System.out.println();
            System.out.print("Enter your Deposited Amount Here: ");
            deposit = SCANNER.nextDouble();
            SCANNER.nextLine();

            if (deposit > 5000) {
                System.out.println("Initial Deposit: " + deposit);
                System.out.println();
            } else {
                System.out.printf(ERROR_MSG, "Not Sufficient Amount In Your A/C");
                valid = false;
            }
        } while (!valid);

        String[][] newCustomers = new String[customers.length + 1][3];
        for (int i = 0; i < customers.length; i++) {
            newCustomers[i] = customers[i];
        }
        newCustomers[newCustomers.length - 1][0] = AcId;
        newCustomers[newCustomers.length - 1][1] = name;
        newCustomers[newCustomers.length - 1][2] = deposit + "";

        customers = newCustomers;

        System.out.printf(SUCCESS_MSG, String.format("%s:%s has been saved successfully", customers.length, name));
        System.out.print("\tDo you want to continue adding (Y/n)? ");
        if (SCANNER.nextLine().strip().equalsIgnoreCase("Y")) {
            System.out.println(CLEAR);
            return addAccount(customers);
        } else {
            System.out.println(CLEAR);
            return DASHBOARD;
        }
    }
}

