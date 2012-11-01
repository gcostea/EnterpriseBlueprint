package ro.codecamp.ebp.feature3.beans;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.manufacturers.ManufacturerService;
import ro.codecamp.ebp.core.api.modules.ModuleRegistryService;
import ro.codecamp.ebp.core.api.modules.RegisteredModule;
import ro.codecamp.ebp.core.api.products.ProductService;

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
    
    public List<String> getManufacturerNames()
    {
        List<String> manufacturerNames =  manufacturerService.getManufacturerNames(10);
        
        for(String manufacturerName : manufacturerNames)
        {
            manufacturerName = String.format(
                "%s (%d Products)", manufacturerName, productService.getProductCountForManufacturer(manufacturerName)
            );
        }
        
        return manufacturerNames;
    }
}
