///used proxy
package Abstraction;

import Creation.Company;

import java.io.IOException;

public interface NewCompany {
    void create_store() throws IOException;
    Company getCompany();
}
