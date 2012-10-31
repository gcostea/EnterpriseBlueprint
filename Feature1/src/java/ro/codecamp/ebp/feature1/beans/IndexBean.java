package ro.codecamp.ebp.feature1.beans;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.modules.ModuleRegistryService;

@Component
@Scope("request")
public class IndexBean 
{   
    @Resource private ModuleRegistryService moduleRegistryService;

    public ModuleRegistryService getModuleRegistryService() 
    {
        return moduleRegistryService;
    }

    public void setModuleRegistryService(ModuleRegistryService moduleRegistryService) 
    {
        this.moduleRegistryService = moduleRegistryService;
    }    
}
