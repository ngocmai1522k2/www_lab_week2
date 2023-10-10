package vn.edu.iuh.fit.backend.configs.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.configs.connection.MySessionFactory;
import vn.edu.iuh.fit.backend.configs.models.Customer;
import vn.edu.iuh.fit.backend.configs.models.Employee;

import java.util.List;

public class CustomerRepository {
    private Transaction trans;
    private SessionFactory sessionFactory;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public CustomerRepository(){
        this.sessionFactory = MySessionFactory.getInstance().getSessionFactory();
    }

    public List<Customer> getAll() {
        try {
            Session session = sessionFactory.openSession();
            trans = session.beginTransaction();
            List<Customer> lst = session.createNamedQuery("Customer.getAll",Customer.class)
                    .getResultList();
            trans.commit();
            return  lst;
        } catch (Exception ex) {
            trans.rollback();
            logger.error(ex.getMessage());
        }
        return null;
    }

    public boolean insert(Customer customer) {
        try{
            Session session = sessionFactory.openSession();
            trans = session.beginTransaction();
            session.persist(customer);
            trans.commit();
            return true;
        } catch (Exception e){
            trans.rollback();
            logger.error(e.getMessage());
        }
        return false;
    }
}
