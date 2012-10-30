package ro.codecamp.ebp.feature1.ext;

import java.net.URL;
import javax.faces.view.facelets.ResourceResolver;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import ro.codecamp.ebp.core.api.modules.RegisteredCoreModule;

public class CustomResourceResolver extends ResourceResolver
{
    private RegisteredCoreModule registeredCoreModule;
    private ResourceResolver parent;
   
    public CustomResourceResolver(ResourceResolver parent) 
    {
        this.parent = parent;

        Bundle currentBundle = FrameworkUtil.getBundle(CustomResourceResolver.class);
        ServiceReference ref = currentBundle.getBundleContext().getServiceReference(
            RegisteredCoreModule.class.getName()
        );        
        registeredCoreModule = (RegisteredCoreModule) currentBundle.getBundleContext().getService(ref);
    }

    @Override
    public URL resolveUrl(String path) 
    {
        URL url = registeredCoreModule.getResource(path);
        
        if (url == null) 
        {
            url = parent.resolveUrl(path);
        }
        
        return url;
    }
}
