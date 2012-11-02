package ro.codecamp.ebp.features.customer.wrappers;

public class CustomerProducts 
{
    private String customerName;
    private Long customerProducts;

    public CustomerProducts(String customerName, Long customerProducts) 
    {
        this.customerName = customerName;
        this.customerProducts = customerProducts;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public Long getCustomerProducts() 
    {
        return customerProducts;
    }

    public void setCustomerProducts(Long customerProducts) 
    {
        this.customerProducts = customerProducts;
    }
}
