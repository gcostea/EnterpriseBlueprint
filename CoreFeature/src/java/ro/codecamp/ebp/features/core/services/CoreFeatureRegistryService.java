package ro.codecamp.ebp.features.core.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.features.FeatureInfo;
import ro.codecamp.ebp.core.api.features.FeatureRegistryService;
import ro.codecamp.ebp.core.api.features.RegistryAwareCoreFeature;
import ro.codecamp.ebp.core.api.features.RegistryAwareFeature;

@Component
public class CoreFeatureRegistryService implements FeatureRegistryService
{
    @Resource private RegistryAwareCoreFeature coreFeature;
    @Resource private List<RegistryAwareFeature> registeredFeatures;
    
    @Override
    public FeatureInfo getCoreFeatureInfo() 
    {
        return coreFeature.getFeatureInfo();
    }

    @Override
    public List<FeatureInfo> getRegisteredFeaturesInfo() 
    {
        List<FeatureInfo> registeredFeaturesInfo = new ArrayList<FeatureInfo>();
        
        for(Iterator iterator = registeredFeatures.iterator(); iterator.hasNext();) 
        {
            RegistryAwareFeature registeredFeature = (RegistryAwareFeature)iterator.next();
            registeredFeaturesInfo.add(registeredFeature.getFeatureInfo());
        }
        
        return registeredFeaturesInfo;
    }  
}
