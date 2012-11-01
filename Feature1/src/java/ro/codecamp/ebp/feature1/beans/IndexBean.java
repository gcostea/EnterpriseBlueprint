package ro.codecamp.ebp.feature1.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.customers.CustomerService;
import ro.codecamp.ebp.core.api.modules.ModuleRegistryService;
import ro.codecamp.ebp.core.api.modules.RegisteredModule;
import ro.codecamp.ebp.core.api.products.ProductService;

@Component
@Scope("request")
public class IndexBean 
{   
    @Resource private ModuleRegistryService moduleRegistryService;
    @Resource private RegisteredModule currentModule;
    @Resource private CustomerService customerService;
    @Resource private ProductService productService;

    public ModuleRegistryService getModuleRegistryService() 
    {
        return moduleRegistryService;
    }

    public RegisteredModule getCurrentModule() 
    {
        return currentModule;
    }
    
    public List<String> getCustomerNames()
    {
        List<String> customerNames = customerService.getCustomerNames(10);
        List<String> customerInfo = new ArrayList<String>();
        
        for(String customerName : customerNames)
        {
            customerInfo.add(String.format(
                "%s (%d Products)", customerName,
                productService.getProductCountForCustomer(customerName)
            ));
        }
        
        return customerInfo;
    }
}
