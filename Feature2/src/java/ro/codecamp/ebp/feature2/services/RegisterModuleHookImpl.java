package ro.codecamp.ebp.feature2.services;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.osgi.framework.BundleContext;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.modules.ModuleInfo;
import ro.codecamp.ebp.core.api.modules.RegisterModuleHook;

@Component
public class RegisterModuleHookImpl implements RegisterModuleHook
{
    @Resource private ServletContext servletContext;
    @Resource private BundleContext bundleContext;    

    @Override
    public ModuleInfo getRegistryInformation() 
    {
        ModuleInfo info = new ModuleInfo();
        
        info.setName(bundleContext.getBundle().getSymbolicName());
        info.setFriendlyName("Feature Two");
        info.setVersion(bundleContext.getBundle().getVersion().toString());
        info.setAppContext(servletContext.getContextPath());
        
        return info;
    }
}
