/////////used a builder


import java.io.IOException;

public class OnlineStoreBuilder extends StoreBuilder{

    @Override
    public StoreBuilder create() throws IOException {
        System.out.println("Let's create a new store");
        this.setStore(new OnlineStore() {
        });
        return this;
    }
}
