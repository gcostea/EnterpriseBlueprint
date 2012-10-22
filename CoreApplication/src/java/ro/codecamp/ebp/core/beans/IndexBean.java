package ro.codecamp.ebp.core.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.modules.ModuleRegisterService;
import ro.codecamp.ebp.core.api.modules.ModuleRegistryInformation;

@Component
@Scope("request")
public class IndexBean 
{   
    @Resource
    private List<ModuleRegisterService> moduleRegisterServices;
    
    public List<ModuleRegistryInformation> getRegisteredModuleInformation()
    {
        List<ModuleRegistryInformation> registeredModulesInformation = new ArrayList<ModuleRegistryInformation>();
        
        for (Iterator iterator = moduleRegisterServices.iterator(); iterator.hasNext();) 
        {
            ModuleRegisterService serviceInst = (ModuleRegisterService)iterator.next();
            registeredModulesInformation.add(serviceInst.getRegistryInformation());
        }
        
        return registeredModulesInformation;
    }
}
