package ro.codecamp.ebp.feature2.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.persistence.TypedQuery;
import org.osgi.service.jpa.EntityManagerFactoryBuilder;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.products.ProductService;

@Component
public class ProductServiceImpl implements ProductService
{
    @Resource private EntityManagerFactoryBuilder entityManagerFactoryBuilder;

    @Override
    public List<String> getProductNames(Integer count) 
    {
        Map props = new HashMap();
        props.put("javax.persistence.jdbc.driver", "org.apache.derby.jdbc.ClientDriver");
        props.put("javax.persistence.jdbc.url", "jdbc:derby://localhost:1527/sample");
        props.put("javax.persistence.jdbc.user", "app");
        props.put("javax.persistence.jdbc.password", "app");
        
        TypedQuery<String> q = entityManagerFactoryBuilder.createEntityManagerFactory(props).
            createEntityManager(props).createQuery("SELECT p.description FROM Product p", String.class);
        q.setMaxResults(count);
        
        return q.getResultList();
    }    
}
