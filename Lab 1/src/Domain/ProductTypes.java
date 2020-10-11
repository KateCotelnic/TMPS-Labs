/////////////used factory pattern

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Milk implements ProductType {
    Product[] milk_products =  new Product[5];
    public Milk() throws IOException {
        String type = "milk";
        int k = 1;
//        assert false;
        milk_products[0] = new Product(type);
//        System.out.println(milk_products[0].getProduct_name() + " " +  milk_products[0].getPrice() + " " + milk_products[0].getProduction_date() + " " + milk_products[0].getExpiration_date());
        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nEnter anything to add a new product or just enter to exit: ");
            String id = br.readLine();
            if (id.length() == 0)
                break;
            else {
                milk_products[k] = milk_products[k-1].clone();
//                System.out.println("again");
                k++;
            }
        }
    }
}

class Cheese implements ProductType {
    Product[] products  =  new Product[5];
    public Cheese() throws IOException {
        String type = "cheese";
        int k = 1;
        products[0] = new Product(type);
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

class Bread implements ProductType {
    Product[] products  =  new Product[5];
    public Bread() throws IOException {
        String type = "bread";
        int k = 1;
        products[0] = new Product(type);
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

class Bun implements ProductType {
    Product[] products  =  new Product[5];
    public Bun() throws IOException {
        String type = "bread";
        int k = 1;
        products[0] = new Product(type);
        while (true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nEnter anything to add a new product or just enter to exit: ");
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
