import java.util.Scanner;

public class Driver
{
    private Scanner input;
    private Store store;
    
    public Driver()
    {
        input = new Scanner(System.in);        
        store = new Store();
        runMenu();
    }

    public static void main (String args[]){
    	Driver app = new Driver();
    }

    private int mainMenu()
    { 
        System.out.println("Shop Menu");
        System.out.println("---------");     
        System.out.println("  1) Add a Product");    
        System.out.println("  2) List the Products");    
        System.out.println("  3) Update a Product");        
        System.out.println("  4) Delete a Product"); 
        System.out.println("---------");     
        System.out.println("  5) List the cheapest product");        
        System.out.println("  6) List the products in our current product line"); 
        System.out.println("  7) Display average product unit cost"); 
        System.out.println("  8) List products that are more expensive than a given price");     
        System.out.println(" ---------");
        System.out.println("  9) Save Products to product.xml");
        System.out.println("  10) Load Products from product.xml");
        System.out.println("---------");
        System.out.println("  0) Exit");
        System.out.print("==>> ");
        int option = input.nextInt();
        return option;
    }

    private void runMenu()
    {
        int option = mainMenu();
        while (option != 0)
        {
           
            switch (option)
            {
               case 1:    addProduct();
            	          break;
               case 2:    System.out.println(store.listProducts());
                          break;
               case 3:    editProduct();
            	          break;
               case 4:    deleteProduct();
                          break;
               case 5:    System.out.println(store.cheapestProduct());
                          break;
               case 6:    System.out.println(store.listCurrentProducts());
                          break;
               case 7:    System.out.println(store.averageProductPrice());
                          break;
               case 8:    System.out.print("Enter the price barrier: ");
                          double price = input.nextDouble();
                          System.out.println(store.listProductsAboveAPrice(price));
                          break;
               case 9:	  try{
            	   			store.save();
                           }
               			  catch (Exception e){
               				  System.out.println("Error writing to file: " + e);
               			  }
               			  break;
               case 10:   try{
   	   			          store.load();
                          }
   			              catch (Exception e){
   				          System.out.println("Error reading from file: " + e);
   			              } 
   			              break;
              default:    System.out.println("Invalid option entered: " + option);
                          break;
            }

            System.out.println("\nPress any key to continue...");
            input.nextLine();
            input.nextLine();  
            
            option = mainMenu();
        }
       
        System.out.println("Exiting... bye");
        System.exit(0);
    }
    
    public void addProduct()
    { 
     double cost = 0;
     int code = 0;
     
            input.nextLine();
      		System.out.print("Please enter the product description: ");
    		String desc  = input.nextLine();
    		
      boolean notGoodInput=false;
    	do{
    	 try{
    		System.out.print("Please enter the product code: ");
    		code = input.nextInt();
    		notGoodInput=true;
    	    }
    		catch(Exception e){
    			String throwOut=input.nextLine();
    			System.out.println("Num expected- you entered text");
    		}
    	} while (!notGoodInput);
    	
    	
    	do{
    		try{
    		System.out.print("Please enter the product cost: ");
    		cost = input.nextDouble();
    		notGoodInput=true;
    		}
    		catch(Exception e){
    			String throwOut=input.nextLine();
    			System.out.println("Num expected- you entered text");
    		}
    	} while (!notGoodInput);
    	
    	System.out.print("Is this product in your current line (y/n): ");
    	char currentProduct = input.next().charAt(0);
    	boolean inCurrentProductLine = false;
    	if ((currentProduct == 'y') || (currentProduct == 'Y'))
    		inCurrentProductLine = true;
    	store.add(new Product(desc, code, cost, inCurrentProductLine ));
}
  
    
    public void editProduct()
    {
    	int code=0;
    	double cost=0;
    	System.out.println(store.listProducts());
   
    	if (store.getProducts().size() != 0){	
    		System.out.print("Index of product to edit ==>");
    		int index = input.nextInt();
    		
    		if (index < store.getProducts().size()){	
    			System.out.print("   Enter a new product description: ");
    			String desc = input.nextLine();
    			desc = input.nextLine();
    			
    		boolean notGoodInput=false;
    			do{
    		    	 try{
    		    		System.out.print("Please enter the product code: ");
    		    		code = input.nextInt();
    		    		notGoodInput=true;
    		    	    }
    		    		catch(Exception e){
    		    			String throwOut=input.nextLine();
    		    			System.out.println("Num expected- you entered text");
    		    		}
    		    	} while (!notGoodInput);
    			
    			do{
    	    		try{
    	    		System.out.print("Please enter the product cost: ");
    	    		cost = input.nextDouble();
    	    		notGoodInput=true;
    	    		}
    	    		catch(Exception e){
    	    			String throwOut=input.nextLine();
    	    			System.out.println("Num expected- you entered text");
    	    		}
    	    	} while (!notGoodInput);
    			
    			System.out.print("   Is this product in your current line (y/n): ");
    			char currentProduct = input.next().charAt(0);
    			boolean inCurrentProductLine = false;
    			if ((currentProduct == 'y') || (currentProduct == 'Y'))
    				inCurrentProductLine = true;

    			Product product = store.getProducts().get(index);
    			product.setProductName(desc);
    			product.setProductCode(code);
    			product.setUnitCost(cost);
    			product.setInCurrentProductLine(inCurrentProductLine);
    		}
    		else
            {
            	System.out.println("There is no product for this index number");
            }
        }
    } 
    
    public void deleteProduct()
    {
    	System.out.println(store.listProducts());
   
    	if (store.getProducts().size() != 0){	
    		System.out.print("Index of product to delete ==>");
    		int index = input.nextInt();
    		
    		if (index < store.getProducts().size()){	
    			store.getProducts().remove(index);
    			System.out.println("Product deleted.");
    		}
    		else
            {
            	System.out.println("There is no product for this index number");
            }
        }
    } 
    
 }