package ro.codecamp.ebp.features.product.beans;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.features.FeatureRegistryService;
import ro.codecamp.ebp.core.api.features.RegistryAwareFeature;
import ro.codecamp.ebp.core.api.services.products.ProductService;

@Component
@Scope("request")
public class IndexBean 
{   
    @Resource private FeatureRegistryService featureRegistryService;
    @Resource private RegistryAwareFeature currentFeature;
    @Resource private ProductService productService;

    public FeatureRegistryService getFeatureRegistryService() 
    {
        return featureRegistryService;
    }

    public RegistryAwareFeature getCurrentFeature() 
    {
        return currentFeature;
    }  
    
    public List<String> getProductNames()
    {
        return productService.getProductNames(20);
    }
}
