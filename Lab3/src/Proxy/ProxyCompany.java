///used proxy
package Proxy;

import Abstraction.NewCompany;
import Abstraction.StoreBuilder;
import Creation.Company;

import java.io.IOException;
import java.util.List;

public class ProxyCompany implements NewCompany {
    private Company company;
    private String name;

    public Company getCompany() {
        return company;
    }

    @Override
    public List<StoreBuilder> getStoreBuilders() {
        return null;
    }

    public ProxyCompany(String name) {
        this.name = name;
    }

    @Override
    public void create_store() throws IOException {
        if(company == null){
            company = new Company(name);
        }
        company.create_store();
    }
}
