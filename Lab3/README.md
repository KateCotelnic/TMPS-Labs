# Behavioral Design Patterns

Author: Cotelnic Ecaterina

## Introduction :
During this laboratory work I:
1.  studied the following structural design patterns:
    * Chain of Responsibility
    * Command
    * Interpreter
    * Iterator
    * Mediator
    * Observer
    * Strategy
   
2. implemented 2 behavioral design patterns (description below):
 - selected behavioral design patterns, which could be implemented in my domain area
 - defined the classes where the patterns will be used
 - created additional classes and objects
 - distributed classes into folders
 
 ##General explanation of domain area
 
 - First of all there is created a company, that has a name and list of stores.
 - While creating a new store there is a possibility to choose would it be an offline or an online store.
 - When a user creates a new store he can choose to create a new owner (name and age) or to keep it by default.
 - Each store has a list of product department.
 - User may choose what kind of product department he wants to create.
 - Then, inside of a product department user may choose a product types (milk, bread etc.), that are hold as array in each product department.
 - And now, user may create a product with name, price, production and expiration date. Products are hold on a list in a corresponding product type.
 
 ## Implementation
 
###Chain of responsibility
 
 The Chain of responsibility pattern is used in all classes in ChainOfResponsibility package.
  
It is used for the user to be easier to change what he wants about the product: price, production date or expiration date.

Chain class:

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

Processor class: 

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
    
and the example of a changer (ChangerPrice):

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
     
 ###Mediator
  
  The Mediator pattern is used in Mediator.Mediator and Creation.Company.
  
 It is used for the user to be able to import/copy the whole data from one store into another one. So the user have possibility to not create all components for the new store, if he wants the same stuff as he had in the previous one. 
 
Mediator:

    public class Mediator {
        public static void import_products(Store from, Store to){
            to.setProductDepartments(from.getProductDepartments());
        }
    }
        
 Method from Company:
 
       public void import_products(int index_from, int index_to){
               Mediator.import_products(this.storeBuilders.get(index_from).getStore(),this.storeBuilders.get(index_to).getStore());
           }

                
## Input/ Output

input for creating the stores:

    What tipe of store you want to create? (offline/online)
    offline
    Let's create a new offline store
    
    Enter the name of the store: 
    Kate's store
    
    Do you want to set a new owner? (y/n)
    y
    new owner
    
    Enter the name of the new owner of the store: 
    Kate
    
    Enter the age of the new owner of the store: 
    21
    
    Enter the department(milk department or bread department) in store you want to add(Or just Enter to exit): 
    milk department
    department milk products is created
    
    Enter the type of milk products (milk or cheese) you want to add or enter to exit: 
    milk
    
    Enter the name of the product: 
    m1
    
    Enter the price of the product: 
    1
    
    Enter the production_date of the product: 
    10.01
    
    Enter the expiration_date of the product: 
    11.01
    
    Enter anything to add a new product or just enter to exit: 
    
    
    Enter the type of milk products (milk or cheese) you want to add or enter to exit: 
    
    
    Enter the department(milk department or bread department) in store you want to add(Or just Enter to exit): 
    
    
    What tipe of store you want to create? (offline/online)
    online
    Let's create a new online store
    
    Enter the name of the store: 
    online store
    
    Do you want to set a new owner? (y/n)
    n
    old owner
    
    Enter the department(milk department or bread department) in store you want to add(Or just Enter to exit): 

input for mediator

    Do you want to import products from previous store?(y/n): 
    y
    
output

    The store "Kate's store" by Kate(21 years)  is created
    Domain.product_departments.MilkProducts:
    Domain.productTypes.Milk:
    m1(price: 1.0, date: 10.01 - 11.01)
    
    The store "online store" by Tom(30 years)  is created
    Domain.product_departments.MilkProducts:
    Domain.productTypes.Milk:
    m1(price: 1.0, date: 10.01 - 11.01)

input for implementation of chain of responsibility

    Do you want to change a product? Enter the name of the product or just enter to exit: 
    m1
    Enter "p" for changing the price, "d" for changing the production date, "e" for changing the expiration date or just enter to exit: 
    p
    
    Enter the price of the product: 
    5
     
output
    
    The store "Kate's store" by Kate(21 years)  is created
    Domain.product_departments.MilkProducts:
    Domain.productTypes.Milk:
    m1(price: 5.0, date: 10.01 - 11.01)
    
    The store "online store" by Tom(30 years)  is created
    Domain.product_departments.MilkProducts:
    Domain.productTypes.Milk:
    m1(price: 5.0, date: 10.01 - 11.01)
