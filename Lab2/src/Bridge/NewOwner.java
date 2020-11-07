/////used bridge
package Bridge;

import Abstraction.SetOwner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewOwner implements SetOwner {
    private static String name;
    private static int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void set(String name, int age) throws IOException {
        System.out.println("new owner");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nEnter the name of the new owner of the store: ");
        String new_name = br.readLine();
        this.name = new_name;
        System.out.println("\nEnter the age of the new owner of the store: ");
        String new_age = br.readLine();
        this.age = Integer.parseInt(new_age);
    }
}
