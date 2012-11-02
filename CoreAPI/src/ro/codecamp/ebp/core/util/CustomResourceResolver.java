package ro.codecamp.ebp.core.util;

import java.net.URL;
import javax.faces.view.facelets.ResourceResolver;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import ro.codecamp.ebp.core.api.features.RegistryAwareCoreFeature;

public class CustomResourceResolver extends ResourceResolver
{
    private RegistryAwareCoreFeature registeredCoreFeature;
    private ResourceResolver parent;
   
    public CustomResourceResolver(ResourceResolver parent) 
    {
        this.parent = parent;

        Bundle currentBundle = FrameworkUtil.getBundle(CustomResourceResolver.class);
        ServiceReference ref = currentBundle.getBundleContext().getServiceReference(
            RegistryAwareCoreFeature.class.getName()
        );        
        registeredCoreFeature = (RegistryAwareCoreFeature) currentBundle.getBundleContext().getService(ref);
    }

    @Override
    public URL resolveUrl(String path) 
    {
        URL url = registeredCoreFeature.getResource(path);
        
        if (url == null) 
        {
            url = parent.resolveUrl(path);
        }
        
        return url;
    }
}
