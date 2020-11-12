# Structural Design Patterns

Author: Cotelnic Ecaterina

## Introduction :
During this laboratory work I:
1.  studied the following structural design patterns:
    * Adapter
    * Bridge
    * Composite
    * Decorator
    * Facade
    * Flyweight
    * Proxy
   
2. implemented 4 structural design patterns (description below):
 - selected structural design patterns, which could be implemented in my domain area (a demo version of the grocery store database in form of objects)
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
 
###Bridge
 
 The Bridge pattern is used in Abstraction.SetOwner, Abstraction.Owner, Bridge.NewOwner, Bridge.OldOwner, Creation.Store.
 
It is used for the user to be able to choose: add a owner of a store with default properties (name, age) or to create a new store owner and to set the properties by himself.

old owner class:

    public class OldOwner implements SetOwner {
        private static String name;
        private static int age;
    
        public String getName() {
            return name;
        }
    
        public int getAge() {
            return age;
        }
    
        public void set(String name, int age) {
            System.out.println("old owner");
            this.name = name;
            this.age = age;
        }
    }

new owner class: 

    public class NewOwner implements SetOwner {
        private static String name;
        private static int age;
    
        public String getName() {
            return name;
        }
    
        public int getAge() {
            return age;
        }
    
        public void set(String name, int age) throws IOException {
            System.out.println("new owner");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nEnter the name of the new owner of the store: ");
            String new_name = br.readLine();
            this.name = new_name;
            System.out.println("\nEnter the age of the new owner of the store: ");
            String new_age = br.readLine();
            this.age = Integer.parseInt(new_age);
        }
    }
    
and the implementation:

    public void setOwner() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\nDo you want to set a new owner? (y/n)");
            String flag = br.readLine();
            String name = "Tom";
            int age = 30;
            if(flag.equals("y")) {
                owner = new ConcreteOwner(name, age, new NewOwner());
            }
            else {
                owner = new ConcreteOwner(name, age, new OldOwner());
            }
            owner.create();
        }
     
 ###Proxy
  
  The Proxy pattern is used in Abstraction.NewCompany, Proxy.ProxyCompany, Creation.Company.
  
 It is used for the user to be able to create only one company and many stores inside one company.
 
Method for creating stores inside Company:

    public void create_store() throws IOException {
            get_type_store();
            Store.isNew = true;
            if(type_store.equals("offline")){
                StoreMaker storeMaker = new StoreMaker();
                storeMaker.createOfflineStore();
            storeBuilders.add(storeMaker.getOfflineStoreBuilder().getStore());
            }
            else if(type_store.equals("online")){
                StoreBuilder newstore =  new OnlineStoreBuilder();
                newstore.create();
                storeBuilders.add(newstore.getStore());
            }
        }
        
 Method to create company and stores inside ProxyCompany:
 
        public void create_store() throws IOException {
            if(company == null){
                company = new Company(name);
            }
            company.create_store();
        }

###Composite

The Composite pattern is used in Creation.Store.
  
 It is used for the user to be able to create stores inside a store. For example, if the owner has an offline store, and he wants to create an online store for it.
 
 Store has a property:
 
    private List<Store> sub_stories;
    
 In constructor of a store there is created a new list:
 
     public Store() throws IOException {
            setName();
            setOwner();
            setProductDepartments();
            sub_stories = new ArrayList<Store>();
        }
 which elements can be added and removed:
 
    public void add(Store store){
            sub_stories.add(store);
        }
    
        public void remove(Store store){
            sub_stories.remove(store);
        }

###Facade

The Facade pattern is used in Facade.StoreMaker, Creation.Company.
  
 It is used for the user to be easier to create new stores.
 
 This is a store maker:
 
    public class StoreMaker {
        private StoreBuilder offlineStoreBuilder;
        private StoreBuilder onlineStoreBuilder;
    
        public StoreMaker(){
            offlineStoreBuilder = new OfflineStoreBuilder();
            onlineStoreBuilder = new OnlineStoreBuilder();
        }

        public void createOnlineStore() throws IOException {
            onlineStoreBuilder.create();
        }
    
        public void createOfflineStore() throws IOException {
            offlineStoreBuilder.create();
        }
    }
    
 and how it is used:
 
    StoreMaker storeMaker = new StoreMaker();
                storeMaker.createOfflineStore();
                
##Output / Result


##Conclusions