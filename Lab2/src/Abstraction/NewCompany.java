///used proxy
package Abstraction;

import Creation.Company;

import java.io.IOException;
import java.util.List;

public interface NewCompany {
    void create_store() throws IOException;
    Company getCompany();
    List<StoreBuilder> getStoreBuilders();
}
