package ro.codecamp.ebp.feature3.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.persistence.TypedQuery;
import org.osgi.service.jpa.EntityManagerFactoryBuilder;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.manufacturers.ManufacturerService;

@Component
public class ManufacturerServiceImpl implements ManufacturerService
{
    @Resource private EntityManagerFactoryBuilder entityManagerFactoryBuilder;

    @Override
    public List<String> getManufacturerNames(Integer count) 
    {
        Map props = new HashMap();
        props.put("javax.persistence.jdbc.driver", "org.apache.derby.jdbc.ClientDriver");
        props.put("javax.persistence.jdbc.url", "jdbc:derby://localhost:1527/sample");
        props.put("javax.persistence.jdbc.user", "app");
        props.put("javax.persistence.jdbc.password", "app");
        
        TypedQuery<String> q = entityManagerFactoryBuilder.createEntityManagerFactory(props).
            createEntityManager(props).createQuery("SELECT m.name FROM Manufacturer m", String.class);
        q.setMaxResults(count);
        
        return q.getResultList();
    }    
}
