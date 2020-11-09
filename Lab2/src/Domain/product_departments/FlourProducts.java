package Domain.product_departments;

import Abstraction.NewProductDepartment;
import Abstraction.ProductType;
import Creation.Store;
import Domain.productTypes.Bread;
import Domain.productTypes.Bun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlourProducts implements NewProductDepartment {
    private static FlourProducts flourProducts = null;
    private static ProductType[] productTypes = new ProductType[100];
    private FlourProducts(){}

    public ProductType[] getProductTypes() {
        return productTypes;
    }

    public static FlourProducts getInstance() throws IOException {
        if (flourProducts == null && Store.isNew){
            synchronized (MilkProducts.class){
                if(flourProducts == null  && Store.isNew){
                    Store.isNew = false;
                    flourProducts = new FlourProducts();
                    System.out.println("department flour products products is created");
                    add_product();
                }
                else {
                    System.out.println("department flour products already exists");
                    add_product();
                }
            }
        }
        else {
            System.out.println("department flour products already exists");
            add_product();
        }
        return flourProducts;
    }

    public static void add_product() throws IOException {
        int k = 0;
        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nEnter the type of flour products (bread or bun) you want to add or enter to exit: ");
            String type = br.readLine();
            if (type.length() == 0)
                break;
            else {
                productTypes[k] = flourProducts.addProducts(type);
                k++;
            }
        }
    }

    @Override
    public ProductType addProducts(String type) throws IOException {
        switch (type){
            case "bread": return new Bread();
            case "bun": return new Bun();
        }
        return null;
    }
}