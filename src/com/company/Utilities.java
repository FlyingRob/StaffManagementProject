package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilities {

    public static Scanner sc = new Scanner(System.in);

    public static final String textReset = "\u001B[0m";
    public static final String textRed = "\u001B[31m";
    public static final String textYellow = "\u001B[33m";
    public static final String textBlue = "\u001B[34m";
    public static final String textPurple = "\u001B[35m";
    public static final String textCyan = "\u001B[36m";

    public static int readInt() {
        int nr = 0;
        boolean loop = true;
        while (loop) {
            try {
                nr = sc.nextInt();
                loop = false;
            } catch (InputMismatchException e) {
                System.out.print(textRed + "Du måste mata in ett heltal. Försök igen: " + textReset);
            } finally {
                sc.nextLine();
            }
        }
        return nr;
    }

    public static void pause() {
        System.out.println(textRed + "\nTryck enter för att fortsätta." + textReset);
        sc.nextLine();
    }

    public static String checkUserSelection(String a, String b) {
        String input = "";
        boolean loop = true;
        while (loop) {
            input = sc.nextLine();
            if (input.equalsIgnoreCase(a) || input.equalsIgnoreCase(b)) {
                loop = false;
            } else {
                System.out.print(textRed + "Du måste ange " + a + " eller " + b + ": " + textReset);
            }
        }
        return input.toUpperCase();
    }

    public static String checkUserSelection(String a, String b, String c) {
        String input = "";
        boolean loop = true;
        while (loop) {
            input = sc.nextLine();
            if (input.equalsIgnoreCase(a) || input.equalsIgnoreCase(b) || input.equalsIgnoreCase(c)) {
                loop = false;
            } else {
                System.out.print(textRed + "Du måste ange " + a + ", " + b + " eller " + c + ": " + textReset);
            }
        }
        return input.toUpperCase();
    }

}
