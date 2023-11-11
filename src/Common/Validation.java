package Common;

import java.util.Scanner;

public class Validation {

    static Scanner sc = new Scanner(System.in);

    public static double getDouble() {
        double result;
        while (true) {
            try {
                result = Double.parseDouble(sc.nextLine());
                if (result < 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.print("Insert a number > 0: ");
            }
        }
    }

    public static int getInt() {
        int result;
        while (true) {
            try {
                result = Integer.parseInt(sc.nextLine());
                if (result < 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.print("Insert a number > 0: ");
            }
        }
    }

    public static int getParentInt() {
        int result;
        while (true) {
            try {
                result = Integer.parseInt(sc.nextLine());
                if (result < 0) {
                    throw new NumberFormatException();
                }
                else if (result > 2) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException b) {
                System.err.print("The maximum and minimum number of adults is 2 and 1. Please retry: ");
            }
        }
    }

    public static boolean checkYN() {
        String result;
        while (true) {
            result = sc.nextLine();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.print("Please Insert y/Y or n/N.");
            System.out.print("\nInsert again: ");
        }
    }

    public static String validateGenderInput() {
        String result;
        while (true) {
            result = sc.nextLine();
            if (result.equalsIgnoreCase("M")) {
                return result;
            } else if (result.equalsIgnoreCase("F")) {
                return result;
            }
            System.out.println("Invalid input. Gender must be 'F' or 'M': ");
        }
    }
}