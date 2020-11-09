package Domain.product_departments;

import Abstraction.NewProductDepartment;
import Abstraction.ProductType;
import Creation.Store;
import Domain.productTypes.Cheese;
import Domain.productTypes.Milk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MilkProducts implements NewProductDepartment {
    private static MilkProducts milkProducts = null;
    private static ProductType[] productTypes = new ProductType[100];
    private MilkProducts(){}

    public ProductType[] getProductTypes() {
        return productTypes;
    }

    public static MilkProducts getInstance() throws IOException {
        if (milkProducts == null && Store.isNew){
            synchronized (MilkProducts.class){
                if(milkProducts == null && Store.isNew){
                    milkProducts = new MilkProducts();
                    System.out.println("department milk products is created");
                    add_product();
                }
                else{
                    System.out.println("department milk products already exists");
                add_product();
                }
            }
        }
        else {
            System.out.println("department milk products already exists");
            add_product();
        }
        return milkProducts;
    }

    public static void add_product() throws IOException {
        int k = 0;
        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nEnter the type of milk products (milk or cheese) you want to add or enter to exit: ");
            String type = br.readLine();
            if (type.length() == 0)
                break;
            else {
                productTypes[k] = milkProducts.addProducts(type);
                k++;
            }
        }
    }

    @Override
    public ProductType addProducts(String type) throws IOException {
        switch (type){
            case "milk": return new Milk();
            case "cheese": return new Cheese();
        }
        return null;
    }
}