package ro.codecamp.ebp.core.api.features;

import java.util.List;

public interface FeatureRegistryService 
{
    FeatureInfo getCoreFeatureInfo();
    List<FeatureInfo> getRegisteredFeaturesInfo();
}
