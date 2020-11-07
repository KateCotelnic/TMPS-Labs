/////////used a builder
package Builders;

import Abstraction.StoreBuilder;
import Stores.OfflineStore;

import java.io.IOException;

public class OfflineStoreBuilder extends StoreBuilder {
    @Override
    public StoreBuilder create() throws IOException {
        System.out.println("Let's create a new offline store");
        this.setStore(new OfflineStore() {
        });
        return this;
    }

    @Override
    public void add(StoreBuilder newstore2) {
    }
}
