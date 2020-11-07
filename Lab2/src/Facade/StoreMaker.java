///used facade
package Facade;

import Abstraction.StoreBuilder;
import Builders.OfflineStoreBuilder;
import Builders.OnlineStoreBuilder;

import java.io.IOException;

public class StoreMaker {
    private StoreBuilder offlineStoreBuilder;
    private StoreBuilder onlineStoreBuilder;

    public StoreMaker(){
        offlineStoreBuilder = new OfflineStoreBuilder();
        onlineStoreBuilder = new OnlineStoreBuilder();
    }

    public StoreBuilder getOfflineStoreBuilder() {
        return offlineStoreBuilder;
    }

    public StoreBuilder getOnlineStoreBuilder() {
        return onlineStoreBuilder;
    }

    public void createOnlineStore() throws IOException {
        onlineStoreBuilder.create();
    }

    public void createOfflineStore() throws IOException {
        offlineStoreBuilder.create();
    }
}
