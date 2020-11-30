package ChainOfResponsibility;

import Creation.Product;

import java.io.IOException;

abstract class Processor
{
    private Processor processor;

    public Processor(Processor processor){
        this.processor = processor;
    };

    public void process(Product product, String n) throws IOException {
        if(processor != null)
            processor.process(product, n);
    }
}