
package Client;

import Abstraction.NewCompany;
import Abstraction.StoreBuilder;
import Creation.Store;
import Proxy.ProxyCompany;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
            NewCompany newCompany = new ProxyCompany("new company");
            newCompany.create_store();
            Store.isNew = true;
            newCompany.create_store();
            newCompany.getStoreBuilders().get(0).add(newCompany.getStoreBuilders().get(1));
            for(StoreBuilder storeBuilder : newCompany.getCompany().getStoreBuilders()) {
                Store.print_store(storeBuilder);
                Store.print_sub_stores(storeBuilder);
            }
    }
}