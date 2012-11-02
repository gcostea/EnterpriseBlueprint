package ro.codecamp.ebp.features.core;

import java.net.URL;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.osgi.framework.BundleContext;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.features.FeatureInfo;
import ro.codecamp.ebp.core.api.features.RegistryAwareCoreFeature;

@Component
public class CoreFeature implements RegistryAwareCoreFeature
{
    @Resource private ServletContext servletContext;
    @Resource private BundleContext bundleContext;    
    
    @Override
    public FeatureInfo getFeatureInfo() 
    {
        FeatureInfo info = new FeatureInfo();
        
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
