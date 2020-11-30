
package Abstraction;

import java.io.IOException;

public interface NewProductDepartment {
    ProductType addProducts(String type) throws IOException;
    ProductType[] getProductTypes();
}
