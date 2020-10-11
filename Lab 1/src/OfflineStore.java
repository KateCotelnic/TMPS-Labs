/////////used a builder

import java.io.IOException;

public class OfflineStore extends Store{

    public OfflineStore() throws IOException {
    }

    @Override
    public void online_offline() {
        System.out.println("This is a offline store");
    }
}
