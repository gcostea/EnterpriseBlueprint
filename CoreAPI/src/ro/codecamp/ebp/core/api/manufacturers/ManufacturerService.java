package ro.codecamp.ebp.core.api.manufacturers;

import java.util.List;

public interface ManufacturerService 
{
    List<String> getManufacturerNames(Integer count);
}
