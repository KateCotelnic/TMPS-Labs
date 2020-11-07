package Domain.productTypes;

import Abstraction.ProductType;
import Creation.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bread implements ProductType {
    private Product[] products  =  new Product[100];

    public Product[] getProducts() {
        return products;
    }

    public Bread() throws IOException {
        String type = "bread";
        int k = 0;
        if(!Product.isFirst_created()) {
            products[k] = new Product(type);
            Product.first_product = products[k];
        }
        else
            products[k] = Product.first_product.clone();
        k++;
        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nEnter anything to add a new product or just enter to exit:  ");
            String id = br.readLine();
            if (id.length() == 0)
                break;
            products[k] = products[0].clone();
            k++;
        }
    }
}

