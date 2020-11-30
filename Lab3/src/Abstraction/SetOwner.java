/////used bridge

package Abstraction;

import java.io.IOException;

public interface SetOwner {
    void set(String name, int age) throws IOException;
    String getName();
    int getAge();
}
