package ro.codecamp.ebp.features.manufacturer.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.eclipse.gemini.blueprint.service.ServiceUnavailableException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.features.FeatureRegistryService;
import ro.codecamp.ebp.core.api.features.RegistryAwareFeature;
import ro.codecamp.ebp.core.api.services.manufacturers.ManufacturerService;
import ro.codecamp.ebp.core.api.services.products.ProductService;
import ro.codecamp.ebp.features.manufacturer.wrappers.ManufacturerProducts;

@Component
@Scope("request")
public class IndexBean 
{   
    @Resource private FeatureRegistryService featureRegistryService;
    @Resource private RegistryAwareFeature currentFeature;
    @Resource private ManufacturerService manufacturerService;
    @Resource private ProductService productService;

    public FeatureRegistryService getFeatureRegistryService() 
    {
        return featureRegistryService;
    } 

    public RegistryAwareFeature getCurrentFeature() 
    {
        return currentFeature;
    }
    
    public List<ManufacturerProducts> getManufacturerInfo()
    {
        List<String> manufacturerNames =  manufacturerService.getManufacturerNames(10);
        List<ManufacturerProducts> manufacturerInfo = new ArrayList<ManufacturerProducts>();
        
        for(String manufacturerName : manufacturerNames)
        {
            try
            {
                manufacturerInfo.add(
                    new ManufacturerProducts(
                        manufacturerName, productService.getProductCountForManufacturer(manufacturerName)
                    )
                );
            }
            catch(ServiceUnavailableException ex)
            {
                manufacturerInfo.add(
                    new ManufacturerProducts(
                        manufacturerName, 0L
                    )
                );
            }
        }
        
        return manufacturerInfo;
    }
}
