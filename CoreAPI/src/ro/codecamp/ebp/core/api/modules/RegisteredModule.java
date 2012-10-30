package ro.codecamp.ebp.core.api.modules;

import java.net.URL;

public interface RegisteredModule 
{
    ModuleInfo getModuleInfo();
    URL getResource(String path);
}
