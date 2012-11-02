package ro.codecamp.ebp.features.core.beans;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.features.FeatureRegistryService;

@Component
@Scope("request")
public class IndexBean 
{
    @Resource private FeatureRegistryService featureRegistryService;

    public FeatureRegistryService getFeatureRegistryService() 
    {
        return featureRegistryService;
    }
}
