package util;

import java.util.Scanner;

public class InputValidator {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("[ERROR] Input tidak boleh kosong! Coba lagi.");
        }
    }

    public static double readNonNegativeDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value >= 0) {
                    return value;
                }
                System.out.println("[ERROR] Nilai tidak boleh negatif!");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input harus berupa angka valid!");
            }
        }
    }

    public static int readIntRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("[ERROR] Pilih angka antara " + min + " sampai " + max + "!");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input harus berupa angka bulat!");
            }
        }
    }
}