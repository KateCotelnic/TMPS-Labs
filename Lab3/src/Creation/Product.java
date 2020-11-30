package Creation;

/////// used prototype pattern

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Product{
    private String product_name;
    private double price;
    private double production_date;
    private double expiration_date;
    private String type;
    public static Product first_product;
    private static boolean first_created = false;

    public static boolean isFirst_created() {
        return first_created;
    }

    public Product(String type) throws IOException {
        first_created = true;
        this.type = type;
        setProduct_name();
        setPrice();
        setProduction_date();
        setExpiration_date();
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter the name of the product: ");
        String name = br.readLine();
        product_name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter the price of the product: ");
        double price = Double.parseDouble(br.readLine());
        this.price = price;
    }

    public double getProduction_date() {
        return this.production_date;
    }

    public void setProduction_date() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter the production_date of the product: ");
        double production_date = Double.parseDouble(br.readLine());
        this.production_date = production_date;
    }

    public double getExpiration_date() {
        return this.expiration_date;
    }

    public void setExpiration_date() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter the expiration_date of the product: ");
        double expiration_date = Double.parseDouble(br.readLine());
        this.expiration_date = expiration_date;
    }

    public Product clone(){
        Product newProduct = null;
        try {
            newProduct = new Product(this.type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newProduct;
    }
}
