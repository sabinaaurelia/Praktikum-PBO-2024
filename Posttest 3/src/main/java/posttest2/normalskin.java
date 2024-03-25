package posttest2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class normalskin extends Soco {

    // Constructor
    public normalskin(String merk, String product, int product_code, int stock, double price, String faceCategory) {
        super(merk, product, product_code, stock, price, faceCategory);
    }

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    // Method untuk memastikan input tidak kosong
    private static String notEmpty() throws IOException {
        String fillString = "";
        while (true) {
            String inputString = input.readLine();
            if (!inputString.trim().isEmpty()) {
                fillString = inputString;
                break;
            } else {
                System.out.println("");
                System.err.print("Input Cannot Be Empty: ");
            }
        }
        return fillString;
    }

    // Method untuk memvalidasi input angka
    private static int validateNumber(boolean requirePositive) throws IOException {
        int fillint = 0;
        while (true) {
            String inputString = input.readLine();
            if (inputString.matches("\\d+")) {
                fillint = Integer.parseInt(inputString);
                if (!requirePositive || fillint > 0) {
                    break;
                } else {
                    System.out.println("");
                    System.err.print("Input Number >= 0: ");
                }
            } else {
                System.out.println("");
                System.err.print("Input Must Be a Number: ");
            }
        }
        return fillint;
    }

    // Method untuk membersihkan layar
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Method untuk menambahkan data produk kulit normal
    public static normalskin addNormalSkin(List<Soco> dataSoco) throws IOException {
        clearScreen();
        System.out.println("====================================================");
        System.out.println("|                 SOCO BEAUTY STORE                |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|                 Add Skincare Data                |");
        System.out.println("====================================================");

        System.out.print("Merk Skincare   : ");
        String merk = notEmpty();
        System.out.print("Product Name    : ");
        String product = notEmpty();
        System.out.print("Product Codes   : ");
        int product_code = validateNumber(true);
        System.out.print("Product Stocks  : ");
        int stock = validateNumber(true);
        System.out.print("Product Prices  : ");
        double price = validateNumber(true);
        String faceCategory = "normalskin";

        normalskin newNormalSkin = new normalskin(merk, product, product_code, stock, price, faceCategory);

        // Tambahkan objek newNormalSkin ke dalam dataSoco
        dataSoco.add(newNormalSkin);

        return newNormalSkin;
    }

    // Method untuk menampilkan data produk
    public static void display(List<Soco> dataSoco) throws IOException {
        clearScreen();
        if (dataSoco.isEmpty()) {
            System.out.println("----------------------------------------------------");
            System.out.println("|                 SOCO BEAUTY STORE                |");
            System.out.println("----------------------------------------------------");
            System.out.println("                  ! Empty Data !                    ");
            System.out.println("----------------------------------------------------");
        } else {
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
                System.out.println("Face Type        : Normal Skin");
                System.out.println("----------------------------------------------------");
            }
        }
    }

    // Method untuk memperbarui data produk
    public static normalskin updateData(List<Soco> dataSoco) throws IOException {
        clearScreen();
        display(dataSoco);

        // Meminta pengguna memilih nomor data yang ingin diupdate
        System.out.print("Enter the Data Number You Want to Update: ");
        try {
            int dataIndex = Integer.parseInt(input.readLine()) - 1;

            // Memastikan nomor data yang dimasukkan valid
            if (dataIndex >= 0 && dataIndex < dataSoco.size()) {
                Soco skinToUpdate = dataSoco.get(dataIndex);

                // Memeriksa apakah data yang akan diupdate adalah produk normal skin
                if (skinToUpdate instanceof normalskin) {
                    normalskin normalSkinToUpdate = (normalskin) skinToUpdate;

                    // Memperbarui data produk
                    clearScreen();
                    System.out.println("====================================================");
                    System.out.println("|                 SOCO BEAUTY STORE                |");
                    System.out.println("|--------------------------------------------------|");
                    System.out.println("|                Update Skincare Data              |");
                    System.out.println("====================================================");
                    System.out.print("Merk Skincare   : ");
                    normalSkinToUpdate.setMerk(notEmpty());
                    System.out.print("Product Name    : ");
                    normalSkinToUpdate.setProduct(notEmpty());
                    System.out.print("Product Codes   : ");
                    normalSkinToUpdate.setProductCode(validateNumber(true));
                    System.out.print("Product Stocks  : ");
                    normalSkinToUpdate.setStock(validateNumber(true));
                    System.out.print("Product Prices  : ");
                    normalSkinToUpdate.setPrice(validateNumber(true));
                    // Karena ini adalah produk normal skin, faceCategory tetap normalskin
                    System.out.println("Data Successfully Updated!");
                    return normalSkinToUpdate;
                } else {
                    System.out.println("Cannot update data. Selected data is not a normal skin product.");
                    return null;
                }
            } else {
                System.out.println("Invalid Data Number!");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format. Please enter a valid data number.");
            return null;
        }
    }

    // Method untuk menghapus data produk
    public static void deleteData(List<Soco> dataSoco) throws IOException {
        clearScreen();
        display(dataSoco);

        // Masukkan nomor data yang akan dihapus
        System.out.print("Enter The Data Number You Want Delete : ");
        int no = Integer.parseInt(input.readLine()) - 1; // Kurangi 1 untuk mengonversi menjadi indeks nol

        // Periksa apakah nomor data yang dimasukkan valid
        if (no >= 0 && no < dataSoco.size()) {
            // Hapus data Soco dari list berdasarkan nomor yang dipilih
            dataSoco.remove(no);
            System.out.println("");
            System.out.println("Data Succesfully Deleted!");
        } else {
            System.out.println("");
            System.out.println("Invalid Data Number!");
        }

        System.out.println("----------------------------------------------------");
    }
}