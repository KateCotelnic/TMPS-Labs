package ChainOfResponsibility;

import Creation.Product;

import java.io.IOException;

class ChangerProductionDate extends Processor
{

    public ChangerProductionDate(Processor processor){
        super(processor);
    }

    public void process(Product product, String n) throws IOException {
        if(n.equals("d"))
        product.setProduction_date();
    }
}