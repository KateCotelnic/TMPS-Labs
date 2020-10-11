/////////used a builder

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Store {
    private String name;
    private String owner;
    private NewProductDepartment[] productDepartments = new NewProductDepartment[5];

    public Store() throws IOException {
        setName();
        setOwner();
        setProductDepartments();
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

    public String getOwner() {
        return owner;
    }

    public void setOwner() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter the name of the owner of the store: ");
        String owner = br.readLine();
        this.owner = owner;
    }

    public NewProductDepartment[] getProductDepartments() {
        return productDepartments;
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
//                productDepartments[k] = new ProductDepartment();
                productDepartments[k] = ProductDepartment.add_product_department(dep);
            } catch (IOException e) {
                e.printStackTrace();
            }
            k++;
        }
    }
    public abstract void online_offline();

}
