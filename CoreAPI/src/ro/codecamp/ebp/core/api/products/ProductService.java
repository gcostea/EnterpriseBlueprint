package ro.codecamp.ebp.core.api.products;

import java.util.List;

public interface ProductService 
{
    List<String> getProductNames(Integer count);
}
