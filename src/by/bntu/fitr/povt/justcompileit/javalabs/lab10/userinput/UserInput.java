package by.bntu.fitr.povt.justcompileit.javalabs.lab10.userinput;


import java.util.Scanner;

/**
 * The user class for work with the system console.
 * Allows to obtain data which the user enters into the system console.
 *
 * @author Just compile IT
 */

public class UserInput {


    /**
     * Method for input string data
     *
     * @param msg
     * @return String object
     */


    public static String inputString(String msg) {

        System.out.print(msg);
        return new Scanner(System.in).next();
    }

    /**
     * Method for receiving Integer number
     *
     * @param msg
     * @return Int numb
     */

    public static int inputInt(String msg) {

        System.out.print(msg);
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNextInt()) {
            System.out.println("That not a number!");
            System.out.print(msg);
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Method for receiving Double number
     *
     * @param msg
     * @return Double num
     */

    public static double inputDouble(String msg) {

        Scanner scanner = new Scanner(System.in);
        System.out.print(msg);

        while (!scanner.hasNextDouble()) {
            System.out.println("That not a number!");
            System.out.print(msg);
            scanner.next();
        }
        return scanner.nextDouble();
    }

    /**
     * Method for input one char symbol
     *
     * @param msg
     * @return Character
     */

    public static char inputChar(String msg) {

        Scanner scanner = new Scanner(System.in);
        System.out.print(msg);

        return scanner.next().charAt(0);
    }


    /**
     * Method for receiving Long number
     *
     * @param msg
     * @return Long number
     */

    public static long inputLong(String msg) {

        System.out.print(msg);
        Scanner scanner = new Scanner(System.in);

        while (!scanner.hasNextLong()) {
            System.out.println("That not a number!");
            System.out.print(msg);
            scanner.next();
        }
        return scanner.nextLong();
    }


}