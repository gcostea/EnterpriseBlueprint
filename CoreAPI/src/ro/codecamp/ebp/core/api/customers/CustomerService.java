package ro.codecamp.ebp.core.api.customers;

import java.util.List;

public interface CustomerService 
{
    List<String> getCustomerNames(Integer count);
}
