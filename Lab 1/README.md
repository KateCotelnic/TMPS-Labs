# Creational Design Patterns

Author: Cotelnic Ecaterina

## Introduction :
During this laboratory work I:
1.  studied the following creational design patterns:
    * Singleton
    * Prototype
    * Factory Method
    * Abstract Factory
    * Builder
    * Object Pooling
   
2. implemented 4 creational design patterns (description below):
 - selected a domain area for the project (creating a demo version of the grocery store database in form of objects)
 - defined the classes where the patterns will be used
 - created the classes and objects
 - distributed classes into folders
 
 ## Implementation
 
 ###Abstract Factory
 
 I used abstract factory method for creating a product departments, because these classes have the similar methods, but different objects inside them. (The classes MilkProducts and FlourProducts are shown in the description of the next pattern).
 
 Factory method is described below, that abstract factory includes.
 
     public final class ProductDepartment {
 
     public static NewProductDepartment add_product_department(String department) throws IOException {
         switch (department){
             case "MilkDepartment":
             case "milk department":
             case "Milk department":
             case "Milk Department": return MilkProducts.getInstance();
             case "BreadDepartment":
             case "bread department":
             case "Bread department":
             case "Bread Department": return FlourProducts.getInstance();
             default: return null;
         }
     }
     }
     
 ###Singleton
 
 In the creation of a store the every product department should be single. I implemented the singleton pattern in two classes, showen below. 
 
    class MilkProducts implements NewProductDepartment {
        private static MilkProducts milkProducts = null;
        ...
    
        public static MilkProducts getInstance() throws IOException {
            if (milkProducts == null){
                synchronized (MilkProducts.class){
                    if(milkProducts == null){
                        milkProducts = new MilkProducts();
                        System.out.println("department milk products is created");
                        ...
                    else
                        System.out.println("department milk products already exists");
                }
            }
            else
                System.out.println("department milk products already exists");
            return milkProducts;
        }
        ...
    }

and 
    
    class FlourProducts implements NewProductDepartment {
        private static FlourProducts flourProducts = null;
        ...
    public static FlourProducts getInstance() throws IOException {
            if (flourProducts == null){
                synchronized (MilkProducts.class){
                    if(flourProducts == null){
                        flourProducts = new FlourProducts();
                        System.out.println("department flour products products is created");
                        ...
                    }
                    else
                        System.out.println("department flour products already exists");
                }
            }
            else
                System.out.println("department flour products already exists");
            return flourProducts;
        }
        ....
    }
   
###Factory Method

I used factory method in creating the product types, because in a product department there could be created different types of products.
        
        
        public static MilkProducts getInstance() throws IOException {
            ....
        @Override
        public ProductType addProducts(String type) throws IOException {
            switch (type){
                case "milk": return new Milk();
                case "cheese": return new Cheese();
            }
            return null;
        }
    }
and the same for the FlourProducts.

    class Cheese implements ProductType {
        Product[] products  =  new Product[5];
        public Cheese() throws IOException {
            ....
        }
    }
 
### Prototype

I used prototype method, namely deep cloning in creating of the product in method clone, that returns a new product.

     class Product {
        private static String product_name;
        private static double price;
        private static double production_date;
        private static double expiration_date;
        private static String type;

    public Product(String type) throws IOException {
        this.type = type;
        setProduct_name();
        setPrice();
        setProduction_date();
        setExpiration_date();
    }

    public void setProduct_name() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter the name of the product: ");
        String name = br.readLine();
        this.product_name = name;
    }

    public void setPrice() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter the price of the product: ");
        double price = Double.parseDouble(br.readLine());
        this.price = price;
    }

    public void setProduction_date() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter the production_date of the product: ");
        double production_date = Double.parseDouble(br.readLine());
        this.production_date = production_date;
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
    
###Builder

I used builder pattern in creating of the store. There could be created two types of store: Online and Offline.

    public abstract class Store {
        private String name;
        private String owner;
        private NewProductDepartment[] productDepartments = new NewProductDepartment[5];
    
        public Store() throws IOException {
            setName();
            setOwner();
            setProductDepartments();
        }
    .....
        public abstract void online_offline();
    }
    
online
    
    public class OnlineStore extends Store{
    
        public OnlineStore() throws IOException {
        }
    
        @Override
        public void online_offline() {
            System.out.println("This is an online store");
        }
    }

offline
    
    public class OfflineStore extends Store{
    
        public OfflineStore() throws IOException {
        }
    
        @Override
        public void online_offline() {
            System.out.println("This is a offline store");
        }
    }
    
builder:

    public abstract class StoreBuilder {
        private Store store;
    
        public Store getStore() {
            return store;
        }
    
        public void setStore(Store store) {
            this.store = store;
        }
        public abstract StoreBuilder create() throws IOException;
    }
    
online store builder

    public class OnlineStoreBuilder extends StoreBuilder{
    
        @Override
        public StoreBuilder create() throws IOException {
            System.out.println("Let's create a new store");
            this.setStore(new OnlineStore() {
            });
            return this;
        }
    }
    
offline store builder

    public class OfflineStoreBuilder extends StoreBuilder{
        @Override
        public StoreBuilder create() throws IOException {
            System.out.println("Let's create a new store");
            this.setStore(new OfflineStore() {
            });
            return this;
        }
    }
    
##Output / Result

This is an example from console ('-' in front of the line means that this was introduced by user):

    
    Let's create a new store
      
    Enter the name of the store: 
    -My store
     
    Enter the name of the owner of the store: 
    -Kate
    
    Enter the department(milk department or bread department) in store you want to add(Or just Enter to exit): 
    -Milk department
    department milk products is created
       
    Enter the type of milk products (milk or cheese) you want to add or enter to exit: 
    -milk
    
    Enter the name of the product: 
    -Burionka
    
    Enter the price of the product: 
    -10.05
    
    Enter the production_date of the product: 
    -01.10
    
    Enter the expiration_date of the product: 
    -10.10
    
    Enter anything to add a new product or just enter to exit: 
    -y
    
    Enter the name of the product: 
    -JLC
    
    Enter the price of the product: 
    -8
    
    Enter the production_date of the product: 
    -2.10
    
    Enter the expiration_date of the product: 
    -10.10
    
    Enter anything to add a new product or just enter to exit: 
    -
    
    Enter the type of milk products (milk or cheese) you want to add or enter to exit: 
    -cheese
    
    Enter the name of the product: 
    -Rosiiskii
    
    Enter the price of the product: 
    -25.40
    
    Enter the production_date of the product: 
    -20.08
    
    Enter the expiration_date of the product: 
    -20.10
    
    Enter anything to add a new product or just enter to exit:  
    -
    
    Enter the type of milk products (milk or cheese) you want to add or enter to exit: 
    -cheese
    
    Enter the name of the product: 
    -Olanda
    
    Enter the price of the product: 
    -10.08
    
    Enter the production_date of the product: 
    -01.09
    
    Enter the expiration_date of the product: 
    -20.09
    
    Enter anything to add a new product or just enter to exit:  
    -
    
    Enter the type of milk products (milk or cheese) you want to add or enter to exit: 
    -
    
    Enter the department(milk department or bread department) in store you want to add(Or just Enter to exit): 
    -MilkDepartment
    department milk products already exists
    
    Enter the department(milk department or bread department) in store you want to add(Or just Enter to exit): 
    -bread department
    department flour products products is created
    
    Enter the type of flour products (bread or bun) you want to add or enter to exit: 
    -bun
    
    Enter the name of the product: 
    -bun with cheese
    
    Enter the price of the product: 
    -12
    
    Enter the production_date of the product: 
    -20.07
    
    Enter the expiration_date of the product: 
    -20.10
    
    Enter anything to add a new product or just enter to exit: 
    -
    
    Enter the type of flour products (bread or bun) you want to add or enter to exit: 
    -
    
    Enter the department(milk department or bread department) in store you want to add(Or just Enter to exit): 
    -

    Process finished with exit code 0

I made so that user need just to introduce the names of products, depatments and other details and the objects are created.