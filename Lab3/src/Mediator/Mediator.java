package Mediator;

import Creation.Store;

public class Mediator {
    public static void import_products(Store from, Store to){
        to.setProductDepartments(from.getProductDepartments());
    }
}
