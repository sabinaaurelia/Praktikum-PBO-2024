package posttest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AdminMenu extends Acc {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public List<Soco> dataSoco;

    public AdminMenu(String username, String password) {
        super(username, password);
        this.dataSoco = new ArrayList<>();
    }

    public List<Soco> getDataSoco() {
        return dataSoco;
    }

    public void setDataSoco(List<Soco> dataSoco) {
        this.dataSoco = dataSoco;
    }

    public void addSocoData(Soco soco) {
        dataSoco.add(soco);
    }

    public void addSkincare(Soco soco) {
        dataSoco.add(soco);
    }
    // Method untuk login admin
    private boolean adminLogin() throws IOException {
        boolean isLoggedIn = false;
        do {
            utilitas.clear();
            System.out.println("----------------------------------------------------");
            System.out.println("|                 SOCO BEAUTY STORE                |");
            System.out.println("====================================================");
            System.out.println("|                 ADMIN LOGIN                      |");
            System.out.println("----------------------------------------------------");
            System.out.print("Enter Username: ");
            String inputUsername = input.readLine();
            System.out.print("Enter Password: ");
            String inputPassword = input.readLine();

            isLoggedIn = inputUsername.equals(getUsername()) && inputPassword.equals(getPass());

            if (!isLoggedIn) {
                System.out.println("Incorrect username or password!!!");
                System.out.print("Try Again? (Y/N): ");
                String tryAgain = input.readLine();
                if (!tryAgain.equalsIgnoreCase("Y")) {
                    break; // Keluar dari perulangan jika tidak ingin mencoba lagi
                }
            }
        } while (!isLoggedIn); // Melanjutkan perulangan selama tidak berhasil masuk

        return isLoggedIn;
    }

    // table account
    public static void tableacc() {
        System.out.println("====================================================");
        System.out.println("|                       WELCOME                    |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|                  SOCO BEAUTY STORE               |");
        System.out.println("====================================================");
    }

    public void mainmenu(List<Soco> dataSoco, User user) throws NumberFormatException, IOException {
        while (true) {
            utilitas.clear();
            tableacc();
            System.out.println("|                   MENU SKINCARE                  |");
            System.out.println("====================================================");
            System.out.println("|          1. Normal Skin Type                     |");
            System.out.println("|          2. Oily Skin Type                       |");
            System.out.println("|          3. Exit                                 |");
            System.out.println("====================================================");
            System.out.print("Enter Your Choice: ");
            String choice = input.readLine();
            switch (choice) {
                case "1":
                    crudNormalskin(dataSoco);
                    break;
                case "2":
                    crudOilyskin(dataSoco);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                    break;
            }
        }
    }

    // Method for CRUD operations on normal skin products
    public void crudNormalskin(List<Soco> dataSoco) throws IOException {
        while (true) {
            utilitas.clear();
            System.out.println("====================================================");
            System.out.println("|                 SOCO BEAUTY STORE                |");
            System.out.println("|--------------------------------------------------|");
            System.out.println("|             NORMAL TYPE SKINCARE MENU            |");
            System.out.println("====================================================");
            System.out.println("|          1. Add Skincare Data                    |");
            System.out.println("|          2. Show Skincare Data                   |");
            System.out.println("|          3. Update Skincare Data                 |");
            System.out.println("|          4. Delete Skincare Data                 |");
            System.out.println("|          5. Back To Menu                         |");
            System.out.println("====================================================");
            System.out.print("Enter Your Choice: ");
            try {
                String choice = input.readLine();

                switch (choice) {
                    case "1":
        normalskin.addNormalSkin(dataSoco);
        this.addSocoData(dataSoco.get(dataSoco.size() - 1));
        break;
    case "2":
        normalskin.display(dataSoco);
        break;
    case "3":
        normalskin.updateData(dataSoco);
        break;
    case "4":
        normalskin.deleteData(dataSoco);
        break;
    case "5":
        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
                utilitas.pause(input); // Menunggu pengguna menekan tombol sebelum kembali ke menu
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method for CRUD operations on oily skin products
    private void crudOilyskin(List<Soco> dataSoco) throws IOException {
        while (true) {
            utilitas.clear();
            System.out.println("====================================================");
            System.out.println("|                 SOCO BEAUTY STORE                |");
            System.out.println("|--------------------------------------------------|");
            System.out.println("|                  OILY SKIN MENU                  |");
            System.out.println("====================================================");
            System.out.println("|          1. Add Oily Skin Data                   |");
            System.out.println("|          2. Show Oily Skin Data                  |");
            System.out.println("|          3. Update Oily Skin Data                |");
            System.out.println("|          4. Delete OilySkin Data                 |");
            System.out.println("|          5. Back to Main Menu                    |");
            System.out.println("====================================================");
            System.out.print("Enter Your Choice: ");
            try {
                String choice = input.readLine();
                switch (choice) {
                    case "1":
                        oilyskin.addOilySkin(dataSoco, input);
                        break;
                    case "2":
                        oilyskin.displayOilySkin(dataSoco);
                        break;
                    case "3":
                        oilyskin.updateOilySkin(dataSoco, input);
                        break;
                    case "4":
                        oilyskin.deleteOilySkin(dataSoco, input);
                        break;
                    case "5":
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
                utilitas.pause(input); // Menunggu pengguna menekan tombol sebelum kembali ke menu
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        AdminMenu adminMenu = new AdminMenu("a", "a");
        List<Soco> dataSoco = new ArrayList<>(); // Inisialisasi list kosong

        // Lakukan login
        if (adminMenu.adminLogin()) {
            // Jika login berhasil, tampilkan menu utama
            adminMenu.setDataSoco(dataSoco);
            adminMenu.mainmenu(dataSoco, null); // Pass null as User object here
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }
}
