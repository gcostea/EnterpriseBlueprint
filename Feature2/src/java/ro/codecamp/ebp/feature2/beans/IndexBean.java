package ro.codecamp.ebp.feature2.beans;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.modules.ModuleInfo;
import ro.codecamp.ebp.core.api.modules.RegisterCoreModuleHook;

@Component
@Scope("request")
public class IndexBean 
{   
    @Resource private RegisterCoreModuleHook registeredCoreModule;
    
    public ModuleInfo getRegisteredCoreModuleInformation()
    {        
        if(registeredCoreModule != null)
        {
            return registeredCoreModule.getRegistryInformation();
        }
        
        return null;
    }
}
