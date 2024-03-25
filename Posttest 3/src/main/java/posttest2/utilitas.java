package posttest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class utilitas {
    // clear screen
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // pause program
    public static void pause(BufferedReader input) {
        System.out.print("Press Anything To Back Menu...");
        try {
            input.readLine(); // Menunggu sampai pengguna menekan sesuatu
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method untuk membaca input dari pengguna dan memastikan bahwa input tidak kosong
    public static String readNonEmptyInput(BufferedReader input, String message) throws IOException {
        String userInput = "";

        while (userInput.trim().isEmpty()) {
            System.out.print(message);
            userInput = input.readLine().trim();
            if (userInput.isEmpty()) {
                System.err.println("Input cannot be empty.");
            }
        }

        return userInput;
    }

    // Method untuk membaca input dari pengguna dan memastikan bahwa input adalah angka positif
    public static int readPositiveNumberInput(BufferedReader input, String message) throws IOException {
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(message);
                String inputString = input.readLine();
                number = Integer.parseInt(inputString);

                if (number > 0) {
                    validInput = true;
                } else {
                    System.err.println("Input must be a positive number.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input format. Please enter a valid number.");
            }
        }

        return number;
    }
    
    public static double readPositiveDoubleInput(BufferedReader input, String message) throws IOException {
        double number = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(message);
                String inputString = input.readLine();
                number = Double.parseDouble(inputString);

                if (number > 0) {
                    validInput = true;
                } else {
                    System.err.println("Input must be a positive number.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input format. Please enter a valid number.");
            }
        }

        return number;
    }
     public static List<Soco> filterByFaceCategory(List<Soco> dataSoco, String faceCategory) {
        List<Soco> filteredList = new ArrayList<>();
        for (Soco soco : dataSoco) {
            if (soco.getFaceCategory().equalsIgnoreCase(faceCategory)) {
                filteredList.add(soco);
            }
        }
        return filteredList;
    }
}
