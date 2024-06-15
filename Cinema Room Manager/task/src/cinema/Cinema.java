package cinema;

import java.util.Scanner;

public class Cinema {
    public static char SEAT_FREE = 'S';
    public static char SEAT_PURCHASED = 'B';

    public static void main(String[] args) {

        final char[][] schemaCinema = buildCinema();

        int itemMenu;

        do {
            showMenu();
            itemMenu = selectedItemMenu();
            router(itemMenu, schemaCinema);
        } while (itemMenu != 0);
    }

    private static char[][] buildCinema() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seatsRow = scanner.nextInt();

        System.out.println();

        return schemaCinema(rows, seatsRow);
    }

    private static void showMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    private static int selectedItemMenu() {
        Scanner scanner = new Scanner(System.in);

        int itemMenu = scanner.nextInt();

        while (itemMenu < 0 || itemMenu > 3) {
            itemMenu = scanner.nextInt();
        }

        return itemMenu;
    }

    private static void router(int itemMenu, char[][] schemaCinema) {
        if (itemMenu == 0) {
            return;
        }

        switch (itemMenu) {
            case 1:
                printCinema(schemaCinema);
                break;
            case 2:
                buyTicket(schemaCinema);
                break;
            case 3:
                showStatistics(schemaCinema);
                break;
        }
    }

    private static void showStatistics(char[][] schemaCinema) {
        System.out.println();
        final int numberPurchasedTickets = getNumberPurchasedTickets(schemaCinema);
        System.out.printf("Number of purchased tickets: %d%n", numberPurchasedTickets);
        System.out.printf("Percentage: %.2f%%%n", getPurchasedTicketsPercentatge(schemaCinema.length, schemaCinema[0].length, numberPurchasedTickets));
        System.out.printf("Current income: $%d%n", getCurrentIncome(schemaCinema));
        System.out.printf("Total income: $%d%n", getTotalIncome(schemaCinema.length, schemaCinema[0].length));
        System.out.println();
    }

    private static void buyTicket(char[][] schemaCinema) {
        Scanner scanner = new Scanner(System.in);

        int row;
        int seat;

        do {
            System.out.println();
            System.out.println("Enter a row number:");
            row = scanner.nextInt() - 1;

            System.out.println("Enter a seat number in that row:");
            seat = scanner.nextInt() - 1;

        } while (isCoordinateOutBounds(schemaCinema, row, seat) || isSeatPurchased(schemaCinema, row, seat));

        int ticketPrice = getTicketPrice(schemaCinema.length, schemaCinema[0].length, row);
        System.out.println("Ticket price: $" + ticketPrice);
        System.out.println();
        choiseSeat(schemaCinema, row, seat);
    }

    private static int getTicketPrice(int rows, int seatsRow, int row) {
        if (rows * seatsRow < 60) {
            return 10;
        }

        return (rows >= 0 && row < rows / 2) ? 10 : 8;
    }

    private static double getPurchasedTicketsPercentatge(int rows, int seats, int numberPurchasedTickets) {
        return ((double) numberPurchasedTickets / (rows * seats)) * 100;
    }

    private static int getCurrentIncome(char[][] schemaCinema) {
        int sum = 0;

        for (int i = 0; i < schemaCinema.length; i++) {
            for (int j = 0; j < schemaCinema[i].length; j++) {
                if (schemaCinema[i][j] == SEAT_FREE) {
                    continue;
                }

                sum += getTicketPrice(schemaCinema.length, schemaCinema[0].length, i);
            }
        }

        return sum;
    }

    private static int getNumberPurchasedTickets(char[][] schemaCinema) {
        int count = 0;

        for (char[] seats : schemaCinema) {
            for (char seat : seats) {
                count += seat == SEAT_FREE ? 0 : 1;
            }
        }

        return count;
    }

    private static int getTotalIncome(int rows, int seatsRow) {
        if (rows * seatsRow < 60) {
            return rows * seatsRow * 10;
        }

        return ((rows / 2) * seatsRow * 10) + ((rows - (rows / 2)) * seatsRow * 8);
    }

    private static void choiseSeat(char[][] schemaCinema, int row, int seat) {
        schemaCinema[row][seat] = SEAT_PURCHASED;
    }

    private static boolean isSeatPurchased(char[][] schemaCinema, int row, int seat) {
        if (schemaCinema[row][seat] == SEAT_PURCHASED) {
            System.out.println("That ticket has already been purchased!");
            return true;
        }

        return false;
    }

    private static boolean isCoordinateOutBounds(char[][] schemaCinema, int row, int seat) {
        if (row > schemaCinema.length - 1 || row < 0 || seat > schemaCinema[0].length - 1 || seat < 0) {
            System.out.println("Wrong input!");
            return true;
        }

        return false;
    }

    private static char[][] schemaCinema(int rows, int seatsRow) {
        char[][] schema = new char[rows][seatsRow];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsRow; j++) {
                schema[i][j] = SEAT_FREE;
            }
        }

        return schema;
    }

    private static void printCinema(char[][] schema) {
        System.out.println("Cinema:");

        String header = "";
        for (int h = 0; h < schema[0].length; h++) {
            header += (h + 1) + " ";
        }

        System.out.println("  " + header.trim());

        for (int i = 0; i < schema.length; i++) {
            String row = (i + 1) + " ";

            for (int j = 0; j < schema[i].length; j++) {
                row += schema[i][j] + " ";
            }

            System.out.println(row.trim());
        }

        System.out.println();
    }
}