package ro.codecamp.ebp.core.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.modules.ModuleInfo;
import ro.codecamp.ebp.core.api.modules.RegisterModuleHook;

@Component
@Scope("request")
public class MainTemplateBean 
{   
    @Resource private List<RegisterModuleHook> registeredModules;
    
    public List<ModuleInfo> getRegisteredModuleInformation()
    {
        List<ModuleInfo> registeredModulesInformation = new ArrayList<ModuleInfo>();
        
        for(Iterator iterator = registeredModules.iterator(); iterator.hasNext();) 
        {
            RegisterModuleHook moduleHook = (RegisterModuleHook)iterator.next();
            registeredModulesInformation.add(moduleHook.getRegistryInformation());
        }
        
        return registeredModulesInformation;
    }
}
