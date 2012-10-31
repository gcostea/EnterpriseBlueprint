package ro.codecamp.ebp.core.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.modules.ModuleInfo;
import ro.codecamp.ebp.core.api.modules.RegisteredCoreModule;
import ro.codecamp.ebp.core.api.modules.RegisteredModule;

@Component
@Scope("request")
public class IndexBean 
{   
    @Resource private List<RegisteredModule> registeredModules;
    @Resource private RegisteredCoreModule registeredCoreModule;
    
    public List<ModuleInfo> getRegisteredModuleInformation()
    {
        List<ModuleInfo> registeredModulesInformation = new ArrayList<ModuleInfo>();
        
        for(Iterator iterator = registeredModules.iterator(); iterator.hasNext();) 
        {
            RegisteredModule registeredModule = (RegisteredModule)iterator.next();
            registeredModulesInformation.add(registeredModule.getModuleInfo());
        }
        
        return registeredModulesInformation;
    }
    
    public ModuleInfo getRegisteredCoreModuleInformation()
    {
        return registeredCoreModule.getModuleInfo();
    }
}
