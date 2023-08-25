import java.util.Scanner;

public class BankAppFinal {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String CLEAR = "\033[H\033[2J";
    private static final String COLOR_BLUE_BOLD = "\033[34;1m";
    private static final String COLOR_RED_BOLD = "\033[31;1m";
    private static final String COLOR_GREEN_BOLD = "\033[33;1m";
    private static final String RESET = "\033[0m";

    private static final String DASHBOARD = "👷 Welcome To Smart Banking System";
    private static final String CREATE_NEW_ACCOUNT = "Create New Account";
    private static final String DEPOSIT = "Deposit";
    private static final String WITHDRAWALS = "Withdrawals";
    private static final String TRANSFER = "Transfer";
    private static final String CHECK_ACCOUNT_BALANCE = "Check Account Balance";
    private static final String DELETE_ACCOUNT = "Delete Account";
    private static final String EXIT = "Exit";

    private static final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
    private static final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);

    private static String[][] accounts = new String[0][3];
    private static int accountIdCounter = 1;

    public static void main(String[] args) {
        String screen = DASHBOARD;
        System.out.println(CLEAR); 

        while (true) {
            
           
            System.out.println("\t[1]. Open New Account");
            System.out.println("\t[2]. Deposit Money");
            System.out.println("\t[3]. Withdraw Money");
            System.out.println("\t[4]. Transfer Money");
            System.out.println("\t[5]. Check Account Balance");
            System.out.println("\t[6]. Drop Existing Account");
            System.out.println("\t[7]. Exit");

            int option = getUserChoice(1, 7);

            switch (option) {
                case 1:
                    System.out.println(CLEAR);
                    screen = createNewAccount();
                    System.out.println(CLEAR);
                    break;
                case 2:
                    System.out.print("\tEnter your account number: ");
                    String depositAccountNumber = SCANNER.nextLine().strip();
                    deposit(depositAccountNumber);
                    break;
                case 3:
                    System.out.print("\tEnter your account number: ");
                    String withdrawalAccountNumber = SCANNER.nextLine().strip();
                    withdrawal(withdrawalAccountNumber);
                    break;
                case 4:
                    System.out.print("\tEnter your account number: ");
                    String transferSourceAccountNumber = SCANNER.nextLine().strip();
                    transfer(transferSourceAccountNumber);
                    break;
                case 5:
                    System.out.print("\tEnter your account number: ");
                    String checkBalanceAccountNumber = SCANNER.nextLine().strip();
                    checkAccountBalance(checkBalanceAccountNumber);
                    break;
                case 6:
                    System.out.print("\tEnter your account number to delete: ");
                    String deleteAccountNumber = SCANNER.nextLine().strip();
                    screen = deleteAccount(deleteAccountNumber);
                    break;
                case 7:
                    System.out.println(CLEAR);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
    private static void displayScreen(String screenTitle) {
        final String APP_TITLE = String.format("%s%s%s", COLOR_BLUE_BOLD, screenTitle, RESET);
        System.out.println(CLEAR);
        System.out.println("\t" + APP_TITLE + "\n");
    }

    private static int getUserChoice(int min, int max) {
        int option;
        do {
            System.out.print("\tEnter an option to continue: ");
            option = SCANNER.nextInt();
            SCANNER.nextLine();
        } while (option < min || option > max);
        return option;
    }
