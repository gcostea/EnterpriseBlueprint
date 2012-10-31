package ro.codecamp.ebp.core.api.modules;

import java.util.List;

public interface ModuleRegistryService 
{
    ModuleInfo getCoreModuleInfo();
    List<ModuleInfo> getRegisteredModulesInfo();
}
