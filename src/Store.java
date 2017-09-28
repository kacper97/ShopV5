import java.util.ArrayList;
import java.util.Iterator;

public class Store
{
    private ArrayList<Product> products;

    public Store()
    {
        products = new ArrayList<Product>();
    }

    
    public ArrayList<Product> getProducts()
    {
    	return products;
    }
    
    public void add (Product product)
    {
        products.add (product); 
    }
    
    public String listProducts()
    {
        String listOfProducts = "";
        int index = 0;
        for (Product product: products)
        {
            listOfProducts = listOfProducts + index + ": " + product.toString() + "\n";
            index++;
        }
        if (listOfProducts.equals(""))
        {
            return "No products";
        }
        else
        {
            return listOfProducts;
        }
        
    }

    public String cheapestProduct()
    {
        if (products.size() > 0)
        {
            Product cheapestProduct = products.get(0);
            for (Product product : products)
            { 
                if (product.getUnitCost() < cheapestProduct.getUnitCost() )  
                    cheapestProduct = product;
            }
            return cheapestProduct.getProductName();
        }
        else 
            return "No Products are in the ArrayList";
    } 
    
    public String listCurrentProducts()
    {
        String str = "";
        
        for (Product product : products)
        {
           if (product.getInCurrentProductLine())            
                str += "Product(code): " + product.getProductName() + "(" 
                    + product.getProductCode() + "): €" + product.getUnitCost() + "\n";   
        }

        if (str.equals(""))
        {
            return "No Products are in our current product line";
        }
        else 
            return str;
    }

    public double averageProductPrice()
    {
        double total = 0;
        for (Product product : products)
        { 
            total = total + product.getUnitCost();
        }
        
        return toTwoDecimalPlaces(total / products.size());
    }
    
    public String listProductsAboveAPrice(double price)
    {
        String str = "";
        for (Product product : products)
        {
           if (product.getUnitCost() > price)
                str += "Product(code): " + product.getProductName() + "(" 
                    + product.getProductCode() + "): €" + product.getUnitCost() + "\n";   
        }

        if (str.equals(""))
        {
            return "No Products are more expensive than: " + price;
        }
        else 
            return str;
    }     
    
    private double toTwoDecimalPlaces(double num)
    {
        return (int) (num *100 ) /100.0; 
    }
    
    public void load() throws Exception{
    	products= HandleXML.read("products.xml");
    }
    
    public void save() throws Exception{
    	HandleXML.write(products, "products.xml");
    }
    
}