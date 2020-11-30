package Creation;

/////////used a builder
///used composite
///used facade
import Abstraction.NewProductDepartment;
import Abstraction.Owner;
import Abstraction.StoreBuilder;
import Bridge.NewOwner;
import Bridge.OldOwner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public abstract class Store {
    public static boolean isNew = true;
    private String name;
    private Owner owner;
    private NewProductDepartment[] productDepartments = new NewProductDepartment[5];
    private List<StoreBuilder> sub_stories = new ArrayList<>();

    public Store() throws IOException {
        setName();
        setOwner();
        setProductDepartments();
        sub_stories = new ArrayList<StoreBuilder>();
    }

    public void add(StoreBuilder store){
        sub_stories.add(store);
    }

    public void remove(Store store){
        sub_stories.remove(store);
    }

    public List<StoreBuilder> getSub_stories() {
        return sub_stories;
    }

    public String getName() {
        return name;
    }

    public void setName() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter the name of the store: ");
        String name = br.readLine();
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nDo you want to set a new owner? (y/n)");
        String flag = br.readLine();
        String name = "Tom";
        int age = 30;
        if(flag.equals("y")) {
            owner = new ConcreteOwner(name, age, new NewOwner());
        }
        else {
            owner = new ConcreteOwner(name, age, new OldOwner());
        }
        owner.create();
    }

    public NewProductDepartment[] getProductDepartments() {
        return productDepartments;
    }

    public void setProductDepartments(NewProductDepartment[] productDepartments){
        this.productDepartments = productDepartments;
    }
    public void setProductDepartments() throws IOException {
        int k =0;
        while (true) {
            try {
                BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("\nEnter the department(milk department or bread department) in store you want to add(Or just Enter to exit): ");
                String dep = read.readLine();
                if (dep.length() == 0)
                    break;
                productDepartments[k] = ProductDepartment.add_product_department(dep);
            } catch (IOException e) {
                e.printStackTrace();
            }
            k++;
        }
    }

    public static void print_store(StoreBuilder newstore){
        System.out.println("The store \"" + newstore.getStore().getName()
                + "\" by " + newstore.getStore().getOwner().getSetOwner().getName()
                +  "(" + newstore.getStore().getOwner().getSetOwner().getAge() + " years) "
                + " is created");
        int i = 0;
        while(newstore.getStore().getProductDepartments()[i]!=null) {
            System.out.println(newstore.getStore().getProductDepartments()[i].getClass().getName() + ":");
            int j = 0;
            while (newstore.getStore().getProductDepartments()[i].getProductTypes()[j] != null) {
                System.out.println(newstore.getStore().getProductDepartments()[i].getProductTypes()[j].getClass().getName() + ":");
                int k = 0;
                while (newstore.getStore().getProductDepartments()[i].getProductTypes()[j].getProducts()[k] != null) {
                    Product product = newstore.getStore().getProductDepartments()[i].getProductTypes()[j].getProducts()[k];
                    System.out.println(product.getProduct_name() + "(price: " + product.getPrice() + ", date: " + product.getProduction_date() +  " - " + product.getExpiration_date() + ")");
                    k++;
                }
                System.out.println();
                j++;
            }
            i++;
        }
    }

    public static void print_sub_stores(StoreBuilder store){
            if (store.getStore().getSub_stories() != null) {
                System.out.print("Store \"" + store.getStore().getName() + "\" contains store(s): ");
                for (StoreBuilder sub_store : store.getStore().getSub_stories()) {
                    System.out.print(sub_store.getStore().getName() + ", ");
                }
            }
            System.out.println();
    }

    public abstract void online_offline();

}

