/////used bridge
package Bridge;

import Abstraction.SetOwner;

public class OldOwner implements SetOwner {
    private static String name;
    private static int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void set(String name, int age) {
        System.out.println("old owner");
        this.name = name;
        this.age = age;
    }
}
