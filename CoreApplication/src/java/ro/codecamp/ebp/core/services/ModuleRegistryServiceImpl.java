package ro.codecamp.ebp.core.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.modules.ModuleInfo;
import ro.codecamp.ebp.core.api.modules.ModuleRegistryService;
import ro.codecamp.ebp.core.api.modules.RegisteredCoreModule;
import ro.codecamp.ebp.core.api.modules.RegisteredModule;

@Component
public class ModuleRegistryServiceImpl implements ModuleRegistryService
{
    @Resource private RegisteredCoreModule registeredCoreModule;
    @Resource private List<RegisteredModule> registeredModules;
    
    @Override
    public ModuleInfo getCoreModuleInfo() 
    {
        return registeredCoreModule.getModuleInfo();
    }

    @Override
    public List<ModuleInfo> getRegisteredModulesInfo() 
    {
        List<ModuleInfo> registeredModulesInformation = new ArrayList<ModuleInfo>();
        
        for(Iterator iterator = registeredModules.iterator(); iterator.hasNext();) 
        {
            RegisteredModule registeredModule = (RegisteredModule)iterator.next();
            registeredModulesInformation.add(registeredModule.getModuleInfo());
        }
        
        return registeredModulesInformation;
    }  
}
