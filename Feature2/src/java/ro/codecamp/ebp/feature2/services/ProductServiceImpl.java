package ro.codecamp.ebp.feature2.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.annotation.Resource;
import javax.persistence.TypedQuery;
import org.osgi.service.jpa.EntityManagerFactoryBuilder;
import org.springframework.stereotype.Component;
import ro.codecamp.ebp.core.api.products.ProductService;

@Component
public class ProductServiceImpl implements ProductService
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
    public List<String> getProductNames(Integer count) 
    {        
        TypedQuery<String> q = entityManagerFactoryBuilder.createEntityManagerFactory(connProps).
            createEntityManager(connProps).createQuery("SELECT p.description FROM Product p", String.class);
        q.setMaxResults(count);
        
        return q.getResultList();
    }    

    @Override
    public Long getProductCountForManufacturer(String manufacturerName) 
    {       
        TypedQuery<Long> q = entityManagerFactoryBuilder.createEntityManagerFactory(connProps).
            createEntityManager(connProps).createQuery(
                "SELECT COUNT(p) FROM Product p WHERE p.manufacturerId.name = :manufacturerName",
                Long.class
        );
        q.setParameter("manufacturerName", manufacturerName);
        
        return q.getSingleResult();
    }

    @Override
    public Long getProductCountForCustomer(String customerName) 
    {        
        TypedQuery<Long> q = entityManagerFactoryBuilder.createEntityManagerFactory(connProps).
            createEntityManager(connProps).createQuery(
                "SELECT COUNT(p) FROM PurchaseOrder p WHERE p.customerId.name = :customerName",
                Long.class
        );
        q.setParameter("customerName", customerName);
        
        return q.getSingleResult();
    }
}
