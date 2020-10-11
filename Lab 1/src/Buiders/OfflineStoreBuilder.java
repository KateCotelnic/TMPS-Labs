/////////used a builder

import java.io.IOException;

public class OfflineStoreBuilder extends StoreBuilder{
    @Override
    public StoreBuilder create() throws IOException {
        System.out.println("Let's create a new store");
        this.setStore(new OfflineStore() {
        });
        return this;
    }
}
