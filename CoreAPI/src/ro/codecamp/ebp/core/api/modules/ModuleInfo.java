package ro.codecamp.ebp.core.api.modules;

public class ModuleInfo 
{
    private String name;
    private String friendlyName;
    private String version;
    private String appContext;
    private Boolean isSelected;

    //<editor-fold desc="Accessors" defaultstate="collapsed">
    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getFriendlyName() 
    {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) 
    {
        this.friendlyName = friendlyName;
    }

    public String getVersion() 
    {
        return version;
    }

    public void setVersion(String version) 
    {
        this.version = version;
    }

    public String getAppContext() 
    {
        return appContext;
    }

    public void setAppContext(String appContext) 
    {
        this.appContext = appContext;
    }  
    //</editor-fold>
}
