///used proxy
package Creation;

import Abstraction.NewCompany;
import Abstraction.StoreBuilder;
import Facade.StoreMaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Company implements NewCompany {
    private String name;
    private String type_store;
    private List<StoreBuilder> storeBuilders = new ArrayList<>();

    public List<StoreBuilder> getStoreBuilders() {
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
        storeBuilders.add(storeMaker.getOfflineStoreBuilder());
        }
        else if(type_store.equals("online")){
            StoreMaker storeMaker = new StoreMaker();
            storeMaker.createOnlineStore();
            storeBuilders.add(storeMaker.getOnlineStoreBuilder());
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
