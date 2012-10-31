package ro.codecamp.ebp.feature1.beans;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.customers.CustomerService;
import ro.codecamp.ebp.core.api.modules.ModuleRegistryService;
import ro.codecamp.ebp.core.api.modules.RegisteredModule;

@Component
@Scope("request")
public class IndexBean 
{   
    @Resource private ModuleRegistryService moduleRegistryService;
    @Resource private RegisteredModule currentModule;
    @Resource private CustomerService customerService;

    public ModuleRegistryService getModuleRegistryService() 
    {
        return moduleRegistryService;
    }

    public void setModuleRegistryService(ModuleRegistryService moduleRegistryService) 
    {
        this.moduleRegistryService = moduleRegistryService;
    } 

    public RegisteredModule getCurrentModule() 
    {
        return currentModule;
    }

    public void setCurrentModule(RegisteredModule currentModule) 
    {
        this.currentModule = currentModule;
    }
    
    public List<String> getCustomerNames()
    {
        return customerService.getCustomerNames(10);
    }
}
