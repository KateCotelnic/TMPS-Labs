
package Client;

import Abstraction.NewCompany;
import Creation.Store;
import Facade.StoreMaker;
import Proxy.ProxyCompany;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            NewCompany newCompany = new ProxyCompany("new company");
            newCompany.create_store();
            Store.isNew = true;

            StoreMaker storeMaker = new StoreMaker();
            storeMaker.createOnlineStore();

            newCompany.getCompany().getStoreBuilders().get(0).add(storeMaker.getOnlineStoreBuilder().getStore());
            for(Store storeBuilder : newCompany.getCompany().getStoreBuilders()) {
                Store.print_store(storeBuilder);
            }
            Store.print_sub_stores(newCompany.getCompany().getStoreBuilders());
            Store.print_sub_stores(Arrays.asList(new Store[]{storeMaker.getOfflineStoreBuilder().getStore(), storeMaker.getOnlineStoreBuilder().getStore()}));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}