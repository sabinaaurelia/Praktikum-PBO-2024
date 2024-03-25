package posttest2;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class oilyskin extends Soco {

    public oilyskin(String merk, String product, int product_code, int stock, double price, String faceCategory) {
        super(merk, product, product_code, stock, price, faceCategory);
    }

    // Method to add oily skin products
    public static void addOilySkin(List<Soco> dataSoco, BufferedReader input) throws IOException {
        utilitas.clear();
        System.out.println("====================================================");
        System.out.println("|                 SOCO BEAUTY STORE                |");
        System.out.println("|--------------------------------------------------|");
        System.out.println("|                 Add Skincare Data                |");
        System.out.println("====================================================");
        String merk = utilitas.readNonEmptyInput(input, "Merk Skincare   : ");
        String product = utilitas.readNonEmptyInput(input, "Product Name    : ");
        int product_code = utilitas.readPositiveNumberInput(input, "Product Codes   : ");
        int stock = utilitas.readPositiveNumberInput(input, "Product Stocks  : ");
        double price = utilitas.readPositiveDoubleInput(input, "Product Prices  : ");
        String faceCategory = "oilyskin";

        oilyskin newOilySkin = new oilyskin(merk, product, product_code, stock, price, faceCategory);
        dataSoco.add(newOilySkin);
    }

    // Method to update oily skin products
    public static void updateOilySkin(List<Soco> dataSoco, BufferedReader input) throws IOException {
        System.out.println("Update Oily Skin Data");
        displayOilySkin(dataSoco);

        int dataIndex = utilitas.readPositiveNumberInput(input, "Enter the Data Number You Want to Update: ") - 1;

        if (dataIndex >= 0 && dataIndex < dataSoco.size()) {
            Soco skinToUpdate = dataSoco.get(dataIndex);

            if (skinToUpdate instanceof oilyskin) {
                oilyskin oilySkinUpdate = (oilyskin) skinToUpdate;

                oilySkinUpdate.setMerk(utilitas.readNonEmptyInput(input, "Merk Skincare   : "));
                oilySkinUpdate.setProduct(utilitas.readNonEmptyInput(input, "Product Name    : "));
                oilySkinUpdate.setProductCode(utilitas.readPositiveNumberInput(input, "Product Codes   : "));
                oilySkinUpdate.setStock(utilitas.readPositiveNumberInput(input, "Product Stocks  : "));
                oilySkinUpdate.setPrice(utilitas.readPositiveDoubleInput(input, "Product Prices  : "));

                System.out.println("Data Successfully Updated!");
            } else {
                System.out.println("Cannot update data. Selected data is not an oily skin product.");
            }
        } else {
            System.out.println("Invalid Data Number!");
        }
    }

    // Method to delete oily skin products
    public static void deleteOilySkin(List<Soco> dataSoco, BufferedReader input) throws IOException {
        System.out.println("Delete Oily Skin Data");
        List<Soco> oilySkinList = utilitas.filterByFaceCategory(dataSoco, "oilyskin");

        if (oilySkinList.isEmpty()) {
            System.out.println("No oily skin data available for deletion.");
        } else {
            displayOilySkin(oilySkinList);

            int indexToDelete = utilitas.readPositiveNumberInput(input, "Enter The Data Number You Want to Delete: ") - 1;

            if (indexToDelete >= 0 && indexToDelete < oilySkinList.size()) {
                Soco deletedOilyskin = oilySkinList.remove(indexToDelete);
                dataSoco.remove(deletedOilyskin);
                System.out.println("Data Successfully Deleted!");
            } else {
                System.out.println("Invalid Data Number!");
            }
        }
    }

    // Method to display oily skin products
    public static void displayOilySkin(List<Soco> dataSoco) {
        if (dataSoco.isEmpty()) {
            System.out.println("Empty Data!");
        } else {
            System.out.println("Oily Skin Products");
            for (int i = 0; i < dataSoco.size(); i++) {
                Soco skincare = dataSoco.get(i);
                if (skincare.getFaceCategory().equals("oilyskin")) {
                    System.out.println("Data " + (i + 1));
                    System.out.println("Merk Skincare    : " + skincare.getMerk());
                    System.out.println("Product Name     : " + skincare.getProduct());
                    System.out.println("Product Codes    : " + skincare.getProductCode());
                    System.out.println("Product Stocks   : " + skincare.getStock());
                    System.out.println("Product Prices   : " + skincare.getPrice());
                    System.out.println("Face Type        : Oily Skin");
                    System.out.println("------------------------");
                }
            }
        }
    }
}
