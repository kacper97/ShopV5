public class Product
{
    private String productName;
    private int productCode;
    private double unitCost;
    private boolean inCurrentProductLine;

    public Product(String productName, int productCode, double unitCost, boolean inCurrentProductLine)
    {
        this.productName = productName;
        this.productCode = productCode;
        this.unitCost = unitCost;
        this.inCurrentProductLine = inCurrentProductLine;
    }
    
    public Product()
    {
    }
    
    public String getProductName()
    {
        return productName;
    }
    
    public double getUnitCost()
    {
        return unitCost;
    }

    public int getProductCode()
    {
        return productCode;
    }
    
    public boolean getInCurrentProductLine()
    {
        return inCurrentProductLine;
    }    
    

	public void setProductName(String productName) {
		this.productName = productName;
	}


	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public void setInCurrentProductLine(boolean inCurrentProductLine) {
		this.inCurrentProductLine = inCurrentProductLine;
	}

    public String toString()
    {
        return "Product description: " + productName
             + ", product code: " + productCode
             + ", unit cost: €" + unitCost
             + ", currently in product line: " + inCurrentProductLine;
    }
    
}