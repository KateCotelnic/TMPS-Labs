/////used bridge

package Creation;

import Abstraction.Owner;
import Abstraction.SetOwner;

import java.io.IOException;

public class ConcreteOwner extends Owner {
    private String name;
    private int age;

    public ConcreteOwner(String name, int age, SetOwner setOwner){
        super(setOwner);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void create() throws IOException {
        setOwner.set(name,age);
    }
}
