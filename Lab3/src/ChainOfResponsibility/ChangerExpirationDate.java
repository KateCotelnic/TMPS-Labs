package ChainOfResponsibility;

import Creation.Product;

import java.io.IOException;

class ChangerExpirationDate extends Processor
{
    public ChangerExpirationDate(Processor processor){
        super(processor);
    }

    public void process(Product product, String n) throws IOException {
        if(n.equals("e"))
        product.setExpiration_date();
    }
}
