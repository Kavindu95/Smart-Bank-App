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
}