/////used bridge

package Abstraction;

import java.io.IOException;

public abstract class Owner {
    protected SetOwner setOwner;

    protected Owner(SetOwner setOwner){
        this.setOwner = setOwner;
    }

    public SetOwner getSetOwner() {
        return setOwner;
    }

    public abstract void create() throws IOException;
}
