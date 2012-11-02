package ro.codecamp.ebp.features.manufacturer.wrappers;

public class ManufacturerProducts 
{
    private String manufacturerName;
    private Long manufacturerProducts;

    public ManufacturerProducts(String manufacturerName, Long manufacturerProducts) 
    {
        this.manufacturerName = manufacturerName;
        this.manufacturerProducts = manufacturerProducts;
    }
    
    public String getManufacturerName() 
    {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) 
    {
        this.manufacturerName = manufacturerName;
    }

    public Long getManufacturerProducts() 
    {
        return manufacturerProducts;
    }

    public void setManufacturerProducts(Long manufacturerProducts) 
    {
        this.manufacturerProducts = manufacturerProducts;
    }       
}
