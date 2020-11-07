package Domain.productTypes;


import Abstraction.ProductType;
import Creation.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Milk implements ProductType {
    private Product[] milk_products =  new Product[100];

    public Product[] getProducts() {
        return milk_products;
    }

    public Milk() throws IOException {
        String type = "milk";
        int k = 0;
//        assert false;
        if(!Product.isFirst_created()) {
            milk_products[k] = new Product(type);
            Product.first_product = milk_products[k];
//            System.out.println("create new " + Product.isFirst_created());
        }
        else
            milk_products[k] = Product.first_product.clone();
        k++;
//        System.out.println(milk_products[0].getProduct_name() + " " +  milk_products[0].getPrice() + " " + milk_products[0].getProduction_date() + " " + milk_products[0].getExpiration_date());
        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nEnter anything to add a new product or just enter to exit: ");
            String id = br.readLine();
            if (id.length() == 0)
                break;
            else {
                milk_products[k] = milk_products[k-1].clone();
                k++;
            }
        }
    }
}
