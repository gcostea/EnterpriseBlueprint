package ro.codecamp.ebp.core.services;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.osgi.framework.BundleContext;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.modules.ModuleInfo;
import ro.codecamp.ebp.core.api.modules.RegisterCoreModuleHook;

@Component
public class RegisterCoreModuleHookImpl implements RegisterCoreModuleHook
{
    @Resource private ServletContext servletContext;
    @Resource private BundleContext bundleContext;    
    
    @Override
    public ModuleInfo getRegistryInformation() 
    {
        ModuleInfo info = new ModuleInfo();
        
        info.setName(bundleContext.getBundle().getSymbolicName());
        info.setFriendlyName("Core Product");
        info.setVersion(bundleContext.getBundle().getVersion().toString());
        info.setAppContext(servletContext.getContextPath());
        
        return info;        
    }    
}
