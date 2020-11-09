///used proxy
package Proxy;

import Abstraction.NewCompany;
import Creation.Company;

import java.io.IOException;

public class ProxyCompany implements NewCompany {
    private Company company;
    private String name;

    public Company getCompany() {
        return company;
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
