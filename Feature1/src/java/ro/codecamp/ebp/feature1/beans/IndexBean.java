package ro.codecamp.ebp.feature1.beans;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.modules.ModuleInfo;
import ro.codecamp.ebp.core.api.modules.RegisteredCoreModule;

@Component
@Scope("request")
public class IndexBean 
{   
    @Resource private RegisteredCoreModule registeredCoreModule;
    
    public ModuleInfo getRegisteredCoreModuleInformation()
    {        
        if(registeredCoreModule != null)
        {
            return registeredCoreModule.getModuleInfo();
        }
        
        return null;
    }
}
