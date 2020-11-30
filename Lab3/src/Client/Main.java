
package Client;

import Abstraction.NewCompany;
import Abstraction.NewProductDepartment;
import Abstraction.ProductType;
import Abstraction.StoreBuilder;
import ChainOfResponsibility.Chain;
import Creation.Product;
import Creation.Store;
import Proxy.ProxyCompany;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
            NewCompany newCompany = new ProxyCompany("new company");
            newCompany.create_store();
            Store.isNew = true;
            newCompany.create_store();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Do you want to import products from previous store?(y/n): ");
        String n = br.readLine();
        if(n.equals("y")){
            newCompany.getCompany().import_products(0,1);
        }
            for(StoreBuilder storeBuilder : newCompany.getCompany().getStoreBuilders()) {
                Store.print_store(storeBuilder);
            }
        while (true){
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Do you want to change a product? Enter the name of the product or just enter to exit: ");
            String name = br.readLine();
            if (name.length() == 0)
                break;
            else {
                System.out.println("Enter \"p\" for changing the price, \"d\" for changing the production date, \"e\" for changing the expiration date or just enter to exit: ");
                n = br.readLine();
                changer(name, newCompany, n);
            }
            for(StoreBuilder storeBuilder : newCompany.getCompany().getStoreBuilders()) {
                Store.print_store(storeBuilder);
            }
            }
        }

    public static void changer(String name,NewCompany newCompany, String n) throws IOException {
        Chain chain = new Chain();
            for (StoreBuilder storeBuilder : newCompany.getCompany().getStoreBuilders()){
                for(NewProductDepartment productDepartment : storeBuilder.getStore().getProductDepartments()){
                    for(ProductType productType: productDepartment.getProductTypes()){
                        for(Product product : productType.getProducts()){
//                            System.out.println(productType.getClass().toString() + " " + product.getProduct_name());
                            if(product.getProduct_name().equals(name)){
//                                System.out.println(product.getProduct_name() + " " + product.getPrice() + " " + product.getProduction_date() + " " + product.getExpiration_date());
                                chain.change(product, n);
                                return;
                            }
                        }
                    }
                }
            }
    }
}