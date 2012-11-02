package ro.codecamp.ebp.features.customer.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.eclipse.gemini.blueprint.service.ServiceUnavailableException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.features.FeatureRegistryService;
import ro.codecamp.ebp.core.api.features.RegistryAwareFeature;
import ro.codecamp.ebp.core.api.services.customers.CustomerService;
import ro.codecamp.ebp.core.api.services.products.ProductService;
import ro.codecamp.ebp.features.customer.wrappers.CustomerProducts;

@Component
@Scope("request")
public class IndexBean 
{   
    @Resource private FeatureRegistryService featureRegistryService;
    @Resource private RegistryAwareFeature currentFeature;
    @Resource private CustomerService customerService;
    @Resource private ProductService productService;

    public FeatureRegistryService getFeatureRegistryService() 
    {
        return featureRegistryService;
    }

    public RegistryAwareFeature getCurrentFeature() 
    {
        return currentFeature;
    }
    
    public List<CustomerProducts> getCustomerInfo()
    {
        List<String> customerNames = customerService.getCustomerNames(20);
        List<CustomerProducts> customerInfo = new ArrayList<CustomerProducts>();
        
        for(String customerName : customerNames)
        {
            try
            {
                customerInfo.add(
                    new CustomerProducts(
                        customerName, productService.getProductCountForCustomer(customerName)
                    )
                );
            }
            catch(ServiceUnavailableException ex)
            {
                customerInfo.add(
                    new CustomerProducts(
                        customerName, 0L
                    )
                );
            }
        }
        
        return customerInfo;
    }
}
