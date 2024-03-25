package posttest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class User extends Acc {
    private ArrayList<Soco> dataSoco;
    private static ArrayList<Acc> DataAkun = new ArrayList<>();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public AdminMenu adminMenu;

    // Konstruktor baru dengan tambahan objek AdminMenu
    public User(String username, String password, AdminMenu adminMenu) {
        super(username, password);
        this.adminMenu = adminMenu; // Inisialisasi objek AdminMenu
        this.dataSoco = new ArrayList<>();
    }

    public User(String username, String password) {
        super(username, password);
        this.dataSoco = new ArrayList<>();
    }

    public void viewSkincareData() {
        List<Soco> dataSoco = adminMenu.getDataSoco(); // Mendapatkan data dari AdminMenu

        // Cek apakah dataSoco kosong
        if (dataSoco.isEmpty()) {
            System.out.println("No skincare products available.");
        } else {
            utilitas.clear();
            System.out.println("----------------------------------------------------");
            System.out.println("|                 SOCO BEAUTY STORE                |");
            System.out.println("----------------------------------------------------");
            for (int i = 0; i < dataSoco.size(); i++) {
                Soco skincare = dataSoco.get(i);
                System.out.println("Data " + (i + 1));
                System.out.println("----------------------------------------------------");
                System.out.println("Merk Skincare    : " + skincare.getMerk());
                System.out.println("Product Name     : " + skincare.getProduct());
                System.out.println("Product Codes    : " + skincare.getProductCode());
                System.out.println("Product Stocks   : " + skincare.getStock());
                System.out.println("Product Prices   : " + skincare.getPrice());
                // Sesuaikan dengan kategori kulit yang sesuai
                if (skincare instanceof normalskin) {
                    System.out.println("Face Type        : Normal Skin");
                } else if (skincare instanceof oilyskin) {
                    System.out.println("Face Type        : Oily Skin");
                }
                System.out.println("----------------------------------------------------");
            }
        }
    }

    public void tambah_akun() throws IOException {
        System.out.println("----------------------------------------------------");
        System.out.println("               >>  Sign In  <<                      ");
        System.out.println("----------------------------------------------------");
        String Username = "";
        String Password = "";
        while (Username.isEmpty()) {
            System.out.print("Username   : ");
            Username = input.readLine().trim();
            if (Username.isEmpty()) {
                System.out.println("Username cannot be empty.");
            }
        }
        while (Password.isEmpty()) {
            System.out.print("Password   : ");
            Password = input.readLine().trim();
            if (Password.isEmpty()) {
                System.out.println("Password cannot be empty.");
            }
        }
        Acc akn = new Acc(Username, Password);
        DataAkun.add(akn);
    }

    public void masuk_akun() throws IOException {
        System.out.println("----------------------------------------------------");
        System.out.println("                   >>  Log In  <<                   ");
        System.out.println("----------------------------------------------------");
        String Username = "";
        String Password = "";
        while (Username.isEmpty()) {
            System.out.print("Username : ");
            Username = input.readLine().trim();
            if (Username.isEmpty()) {
                System.out.println("Username cannot be empty.");
            }
        }
        while (Password.isEmpty()) {
            System.out.print("Password : ");
            Password = input.readLine().trim();
            if (Password.isEmpty()) {
                System.out.println("The password cannot be empty.");
            }
        }

        boolean loginSuccess = false;
        for (Acc akun : DataAkun) {
            if (akun.getUsername().equals(Username) && akun.getPass().equals(Password)) {
                loginSuccess = true;
                break;
            }
        }
        if (loginSuccess) {
            System.out.println("Login Succesfully");
            menu_user();
        } else {
            System.out.println("Login failed. Incorrect username or password.");
        }
    }

    public void menu_user() throws IOException {
        boolean exit = true;
        while (exit) {
            utilitas.clear();
            System.out.println("----------------------------------------------------");
            System.out.println("|                 SOCO BEAUTY STORE                |");
            System.out.println("----------------------------------------------------");
            System.out.println("|       1. Show Data Skincare                      |");
            System.out.println("|       2. Exit                                    |");
            System.out.println("----------------------------------------------------");
            System.out.print("Enter The Option : ");
            try {
                int pilih = Integer.parseInt(input.readLine());
                switch (pilih) {
                    case 1:
                        viewSkincareData();
                        utilitas.pause(input);
                        break;
                    case 2:
                        exit = false;
                        break;
                    default:
                        System.out.println("Invalid");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Must Be Number!");
            }
        }
    }
}
