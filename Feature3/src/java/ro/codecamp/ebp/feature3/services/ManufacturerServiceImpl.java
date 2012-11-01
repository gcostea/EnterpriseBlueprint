package ro.codecamp.ebp.feature3.services;

import java.util.List;
import java.util.Properties;
import javax.annotation.Resource;
import javax.persistence.TypedQuery;
import org.osgi.service.jpa.EntityManagerFactoryBuilder;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.manufacturers.ManufacturerService;

@Component
public class ManufacturerServiceImpl implements ManufacturerService
{
    @Resource private EntityManagerFactoryBuilder entityManagerFactoryBuilder;

    //<editor-fold defaultstate="collapsed" desc="Connection Details">
    private static Properties connProps;
    {
        connProps = new Properties();
        connProps.put("javax.persistence.jdbc.driver", "org.apache.derby.jdbc.ClientDriver");
        connProps.put("javax.persistence.jdbc.url", "jdbc:derby://localhost:1527/sample");
        connProps.put("javax.persistence.jdbc.user", "app");
        connProps.put("javax.persistence.jdbc.password", "app");
    }
    //</editor-fold>
    
    @Override
    public List<String> getManufacturerNames(Integer count) 
    {       
        TypedQuery<String> q = entityManagerFactoryBuilder.createEntityManagerFactory(connProps).
            createEntityManager(connProps).createQuery("SELECT m.name FROM Manufacturer m", String.class);
        q.setMaxResults(count);
        
        return q.getResultList();
    }    
}
