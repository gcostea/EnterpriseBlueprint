package ro.codecamp.ebp.core.util;

import java.net.MalformedURLException;
import java.net.URL;
import javax.faces.context.ExternalContext;
import javax.faces.context.ExternalContextWrapper;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import ro.codecamp.ebp.core.api.features.RegistryAwareCoreFeature;

public class CustomExternalContext extends ExternalContextWrapper 
{
    private RegistryAwareCoreFeature registeredCoreFeature;
    private ExternalContext wrapped;

    public CustomExternalContext(ExternalContext externalContext) 
    {
        wrapped = externalContext;
        Bundle currentBundle = FrameworkUtil.getBundle(CustomResourceResolver.class);
        ServiceReference ref = currentBundle.getBundleContext().getServiceReference(
            RegistryAwareCoreFeature.class.getName()
        );        
        registeredCoreFeature = (RegistryAwareCoreFeature) currentBundle.getBundleContext().getService(ref);
    }

    @Override
    public URL getResource(String path) throws MalformedURLException 
    {
        URL url = registeredCoreFeature.getResource(path);
        
        if (url == null) 
        {
            url = getWrapped().getResource(path);
        }
        
        return url;
    }

    @Override
    public ExternalContext getWrapped() 
    {
        return wrapped;
    }
}
