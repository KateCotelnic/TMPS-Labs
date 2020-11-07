package Stores;

/////////////used a builder

import Creation.Store;

import java.io.IOException;

public class OnlineStore extends Store {

    public OnlineStore() throws IOException {
    }

    @Override
    public void online_offline() {
        System.out.println("This is an online store");
    }
}