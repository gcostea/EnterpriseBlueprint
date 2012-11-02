package ro.codecamp.ebp.features.customer.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.persistence.TypedQuery;
import org.osgi.service.jpa.EntityManagerFactoryBuilder;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.services.customers.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService
{
    @Resource private EntityManagerFactoryBuilder entityManagerFactoryBuilder;
    
    @Override
    public List<String> getCustomerNames(Integer count) 
    {        
        //<editor-fold defaultstate="collapsed" desc="Connection Info">
        Map connProps = new HashMap();
        connProps.put("javax.persistence.jdbc.driver", "org.apache.derby.jdbc.ClientDriver");
        connProps.put("javax.persistence.jdbc.url", "jdbc:derby://localhost:1527/sample");
        connProps.put("javax.persistence.jdbc.user", "app");
        connProps.put("javax.persistence.jdbc.password", "app");
        //</editor-fold>

        TypedQuery<String> q = entityManagerFactoryBuilder.createEntityManagerFactory(connProps).
            createEntityManager(connProps).createQuery("SELECT c.name FROM Customer c", String.class);
        q.setMaxResults(count);
        
        return q.getResultList();
    }    
}
