package ChainOfResponsibility;

import Creation.Product;

import java.io.IOException;

class ChangerPrice extends Processor
{
    public ChangerPrice(Processor processor){
        super(processor);

    }

    public void process(Product product, String n) throws IOException {
        if(n.equals("p"))
        product.setPrice();
    }
}
