package posttest2;

public class Soco {

    String merk;
    String product;
    int product_code;
    int stock;
    double price;

    public Soco(String merks, String products,
            int product_codes, int stocks, double prices) {
        this.merk = merks;
        this.product = products;
        this.product_code = product_codes;
        this.stock = stocks;
        this.price = prices;
    }

    // Getter dan setter untuk variabel merk
    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    // Getter dan setter untuk variabel product
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    // Getter dan setter untuk variabel product_code
    public int getProductCode() {
        return product_code;
    }

    public void setProductCode(int product_code) {
        this.product_code = product_code;
    }

    // Getter dan setter untuk variabel stock
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Getter dan setter untuk variabel price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}