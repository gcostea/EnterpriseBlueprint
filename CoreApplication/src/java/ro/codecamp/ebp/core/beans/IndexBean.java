package ro.codecamp.ebp.core.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.NavigationService;

@Component
@Scope("request")
public class IndexBean 
{   
    @Resource
    private List navigationServices;
    
    public List<String> getFeatures()
    {
        List<String> features = new ArrayList<String>();
        
        for (Iterator iterator = navigationServices.iterator(); iterator.hasNext();) 
        {
            NavigationService serviceInst = (NavigationService)iterator.next();
            features.add(serviceInst.getSectionName());
        }
        
        return features;
    }

    public List getNavigationServices() {
        return navigationServices;
    }

    public void setNavigationServices(List navigationServices) {
        this.navigationServices = navigationServices;
    }
}
