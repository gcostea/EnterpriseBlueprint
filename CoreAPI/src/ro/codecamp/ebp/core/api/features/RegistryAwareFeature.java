package ro.codecamp.ebp.core.api.features;

import java.net.URL;

public interface RegistryAwareFeature 
{
    FeatureInfo getFeatureInfo();
    URL getResource(String path);
}
