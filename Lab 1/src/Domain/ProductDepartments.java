/////////////used abstract factory pattern
/////////// used singleton pattern

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MilkProducts implements NewProductDepartment {
    private static MilkProducts milkProducts = null;
    private MilkProducts(){}

    public static MilkProducts getInstance() throws IOException {
        if (milkProducts == null){
            synchronized (MilkProducts.class){
                if(milkProducts == null){
                    milkProducts = new MilkProducts();
                    System.out.println("department milk products is created");
                    while (true){
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("\nEnter the type of milk products (milk or cheese) you want to add or enter to exit: ");
                        String type = br.readLine();
                        if (type.length() == 0)
                            break;
                        else {
                            milkProducts.addProducts(type);
                        }
                    }
//                    new Product("milk product");
                }
                else
                    System.out.println("department milk products already exists");
            }
        }
        else
            System.out.println("department milk products already exists");
        return milkProducts;
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

class FlourProducts implements NewProductDepartment {
    private static FlourProducts flourProducts = null;
    private FlourProducts(){}

    public static FlourProducts getInstance() throws IOException {
        if (flourProducts == null){
            synchronized (MilkProducts.class){
                if(flourProducts == null){
                    flourProducts = new FlourProducts();
                    System.out.println("department flour products products is created");
                    while (true){
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("\nEnter the type of flour products (bread or bun) you want to add or enter to exit: ");
                        String type = br.readLine();
                        if (type.length() == 0)
                            break;
                        else {
                            flourProducts.addProducts(type);
                        }
                    }
//                    new Product("milk product");
                }
                else
                    System.out.println("department flour products already exists");
            }
        }
        else
            System.out.println("department flour products already exists");
        return flourProducts;
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
