package ro.codecamp.ebp.core.api.services.manufacturers;

import java.util.List;

public interface ManufacturerService 
{
    List<String> getManufacturerNames(Integer count);
}
