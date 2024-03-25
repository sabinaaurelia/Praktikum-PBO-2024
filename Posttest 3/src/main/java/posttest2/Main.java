package posttest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        AdminMenu MyAdmin = new AdminMenu("sabina", "pw123"); // Ganti dengan parameter sesuai kebutuhan
        User currentuser = new User("username", "password", MyAdmin);

        List<Soco> dataSoco = new ArrayList<>(); // Inisialisasi dataSoco
        MyAdmin.setDataSoco(dataSoco);
        while (true) {
            System.out.println("----------------------------------------------------");
            System.out.println("|                 SOCO BEAUTY STORE                |");
            System.out.println("|---------------------------------------------------");
            System.out.println("|                   H e l l o !                    |");
            System.out.println("|---------------------------------------------------");
            System.out.println("|           1. Admin                               |");
            System.out.println("|           2. User                                |");
            System.out.println("|           3. Exit                                |");
            System.out.println("----------------------------------------------------");
            System.out.print("Enter the option you want >> ");
            try {
                int pilih = Integer.parseInt(input.readLine());
                switch (pilih) {
                    case 1:
                        utilitas.clear();
                        System.out.print("Username  >>> ");
                        String username = input.readLine();
                        System.out.print("Password  >>> ");
                        String password = input.readLine();
                        if (username.equalsIgnoreCase(MyAdmin.getUsername())
                                && password.equalsIgnoreCase(MyAdmin.getPass())) {
                            AdminMenu adminMenu = new AdminMenu(username, password);
                            adminMenu.mainmenu(dataSoco, currentuser); // Pass dataSoco and currentuser to the mainmenu
                                                                       // method
                        } else {
                            System.out.println("Incorrect username or password!!!");
                            utilitas.pause(input);
                        }
                        break;
                    // Handle other cases
                    case 2:
                        while (true) {
                            utilitas.clear();
                            System.out.println("----------------------------------------------------");
                            System.out.println("|                 SOCO BEAUTY STORE                |");
                            System.out.println("|---------------------------------------------------");
                            System.out.println("|                      User Menu                   |");
                            System.out.println("|---------------------------------------------------");
                            System.out.println("|           1. Sign In                             |");
                            System.out.println("|           2. Log In                              |");
                            System.out.println("|           3. Back To Main Menu                   |");
                            System.out.println("----------------------------------------------------");
                            System.out.print("Enter the option you want >> ");
                            try {
                                int userChoice = Integer.parseInt(input.readLine());
                                switch (userChoice) {
                                    case 1:
                                        utilitas.clear();
                                        currentuser.tambah_akun();
                                        utilitas.pause(input);
                                        break;
                                    case 2:
                                        utilitas.clear();
                                        currentuser.masuk_akun();
                                        break;
                                    case 3:
                                        break;
                                    default:
                                        System.out.println("Invalid");
                                        break;
                                }
                                if (userChoice == 3) {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Must be Number");
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Wanna Leave This Program? (Y/N): ");
                        String konfirmasi = input.readLine();
                        if (konfirmasi.equalsIgnoreCase("Y") || konfirmasi.equalsIgnoreCase("y")) {
                            System.out.println("See u dear!");
                            System.exit(0);
                        }
                        break;
                    default:
                        System.out.println("Invalid");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Must Be Number");
            }
        }
    }
}
