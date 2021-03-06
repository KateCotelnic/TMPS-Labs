/////////used a builder

import java.io.IOException;

public abstract class StoreBuilder {
    private Store store;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    public abstract StoreBuilder create() throws IOException;
}
