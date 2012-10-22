package ro.codecamp.ebp.core.api.modules;

public class ModuleRegistryInformation 
{
    private String moduleName;
    private String moduleFriendlyName;
    private String moduleVersion;
    private String moduleContext;

    public String getModuleName() 
    {
        return moduleName;
    }

    public void setModuleName(String moduleName) 
    {
        this.moduleName = moduleName;
    }

    public String getModuleFriendlyName() 
    {
        return moduleFriendlyName;
    }

    public void setModuleFriendlyName(String moduleFriendlyName) 
    {
        this.moduleFriendlyName = moduleFriendlyName;
    }
    
    public String getModuleVersion()
    {
        return moduleVersion;
    }

    public void setModuleVersion(String moduleVersion) 
    {
        this.moduleVersion = moduleVersion;
    }

    public String getModuleContext() 
    {
        return moduleContext;
    }

    public void setModuleContext(String moduleContext) 
    {
        this.moduleContext = moduleContext;
    }
}
