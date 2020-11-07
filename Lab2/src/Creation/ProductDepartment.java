package Creation;

/////////////used abstract factory pattern

import Abstraction.NewProductDepartment;
import Domain.product_departments.FlourProducts;
import Domain.product_departments.MilkProducts;

import java.io.IOException;

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
