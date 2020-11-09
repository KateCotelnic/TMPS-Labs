///used proxy
package Creation;

import Abstraction.NewCompany;
import Abstraction.StoreBuilder;
import Builders.OnlineStoreBuilder;
import Facade.StoreMaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Company implements NewCompany {
    private String name;
    private String type_store;
    private List<Store> storeBuilders;

    public List<Store> getStoreBuilders() {
        return storeBuilders;
    }

    public Company(String name) throws IOException {
        this.name = name;
    }

    @Override
    public void create_store() throws IOException {
        get_type_store();
        Store.isNew = true;
        if(type_store.equals("offline")){
            StoreMaker storeMaker = new StoreMaker();
            storeMaker.createOfflineStore();
//            System.out.println(storeMaker.getOfflineStoreBuilder().getStore().getOwner().getSetOwner().getName());
        storeBuilders.add(storeMaker.getOfflineStoreBuilder().getStore());
        }
        else if(type_store.equals("online")){
            StoreBuilder newstore =  new OnlineStoreBuilder();
            newstore.create();
            storeBuilders.add(newstore.getStore());
        }
    }

    @Override
    public Company getCompany() {
        return null;
    }

    public void get_type_store() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nWhat tipe of store you want to create? (offline/online)");
        type_store = br.readLine();
    }
}
