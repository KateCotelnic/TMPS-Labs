package ChainOfResponsibility;

import Creation.Product;

import java.io.IOException;

public class Chain
{
    Processor chain;

    public Chain(){
        buildChain();
    }

    private void buildChain(){
        chain = new ChangerPrice(new ChangerProductionDate(new ChangerExpirationDate(null)));
    }

    public void change(Product request, String n) throws IOException {
        chain.process(request, n);
    }

}