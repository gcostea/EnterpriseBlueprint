package ro.codecamp.ebp.core.services;

import java.net.URL;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.osgi.framework.BundleContext;
import ro.codecamp.ebp.core.api.modules.ModuleInfo;
import ro.codecamp.ebp.core.api.modules.RegisteredCoreModule;

public class RegisteredCoreModuleImpl implements RegisteredCoreModule
{
    @Resource private ServletContext servletContext;
    @Resource private BundleContext bundleContext;    
    
    @Override
    public ModuleInfo getModuleInfo() 
    {
        ModuleInfo info = new ModuleInfo();
        
        info.setName(bundleContext.getBundle().getSymbolicName());
        info.setFriendlyName("Core Feature");
        info.setVersion(bundleContext.getBundle().getVersion().toString());
        info.setAppContext(servletContext.getContextPath());
        
        return info;        
    }    

    @Override
    public URL getResource(String path) 
    {
        return bundleContext.getBundle().getEntry(path);
    }
}
