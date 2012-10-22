package ro.codecamp.ebp.feature1.services;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.osgi.framework.BundleContext;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.modules.ModuleRegisterService;
import ro.codecamp.ebp.core.api.modules.ModuleRegistryInformation;

@Component
public class ModuleRegisterServiceImpl implements ModuleRegisterService
{
    @Resource private ServletContext servletContext;
    @Resource private BundleContext bundleContext;    

    @Override
    public ModuleRegistryInformation getRegistryInformation() 
    {
        ModuleRegistryInformation info = new ModuleRegistryInformation();
        
        info.setModuleName(bundleContext.getBundle().getSymbolicName());
        info.setModuleVersion(bundleContext.getBundle().getVersion().toString());
        info.setModuleContext(servletContext.getContextPath());
        
        return info;
    }
}
