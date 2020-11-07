package Domain.productTypes;


import Abstraction.ProductType;
import Creation.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cheese implements ProductType {
    private Product[] products  =  new Product[100];

    public Product[] getProducts() {
        return products;
    }

    public Cheese() throws IOException {
        String type = "cheese";
        int k = 0;
        if(!Product.isFirst_created()) {
            products[k] = new Product(type);
            Product.first_product = products[k];
        }
        else
//            System.out.println(Main.newstore.getStore().getProductDepartments()[0].getProductTypes()[0].getClass().getName());
            products[k] = Product.first_product.clone();
        k++;
        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nEnter anything to add a new product or just enter to exit:  ");
            String id = br.readLine();
            if (id.length() == 0)
                break;
            else {
                products[k] = products[0].clone();
                k++;
            }
        }
    }
}