package ro.codecamp.ebp.feature3.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.eclipse.gemini.blueprint.service.ServiceUnavailableException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.manufacturers.ManufacturerService;
import ro.codecamp.ebp.core.api.modules.ModuleRegistryService;
import ro.codecamp.ebp.core.api.modules.RegisteredModule;
import ro.codecamp.ebp.core.api.products.ProductService;
import ro.codecamp.ebp.feature3.wrappers.ManufacturerProducts;

@Component
@Scope("request")
public class IndexBean 
{   
    @Resource private ModuleRegistryService moduleRegistryService;
    @Resource private RegisteredModule currentModule;
    @Resource private ManufacturerService manufacturerService;
    @Resource private ProductService productService;

    public ModuleRegistryService getModuleRegistryService() 
    {
        return moduleRegistryService;
    } 

    public RegisteredModule getCurrentModule() 
    {
        return currentModule;
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
