package ro.codecamp.ebp.feature1.services;

import ro.codecamp.ebp.core.api.NavigationService;

public class NavigationServiceImpl implements NavigationService
{
    @Override
    public String getSectionName() 
    {
        return "Feature 1";
    }
    
}
