/////////used a builder
package Builders;

import Abstraction.StoreBuilder;
import Stores.OnlineStore;

import java.io.IOException;

public class OnlineStoreBuilder extends StoreBuilder {

    @Override
    public StoreBuilder create() throws IOException {
        System.out.println("Let's create a new online store");
        this.setStore(new OnlineStore() {
        });
        return this;
    }

    @Override
    public void add(StoreBuilder newstore2) {

    }
}
