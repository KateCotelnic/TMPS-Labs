
package Client;

import Abstraction.StoreBuilder;
import Builders.OfflineStoreBuilder;
import Creation.Store;
import Facade.StoreMaker;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            OfflineStoreBuilder newstore =  new OfflineStoreBuilder();
            newstore.create();
            Store.isNew = true;
            StoreMaker storeMaker = new StoreMaker();
            storeMaker.createOnlineStore();
            newstore.add(storeMaker.getOnlineStoreBuilder());

            Store.print_store(newstore);
            Store.print_sub_stores(Arrays.asList(new StoreBuilder[]{newstore, storeMaker.getOfflineStoreBuilder(), storeMaker.getOnlineStoreBuilder()}));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}