package vn.edu.iuh.fit.backend.configs.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.configs.connection.MySessionFactory;
import vn.edu.iuh.fit.backend.configs.enumClass.EmployeeStatus;
import vn.edu.iuh.fit.backend.configs.models.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private Transaction trans;
    private SessionFactory sessionFactory;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeRepository(){
        this.sessionFactory = MySessionFactory.getInstance().getSessionFactory();
    }
    public void insertEmp(Employee employee) {
        try {
            Session session = sessionFactory.openSession();
            trans = session.beginTransaction();
            session.persist(employee);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }
//    public void setStatus(Employee employee, EmployeeStatus status) {
//        employee.setStatus(status);
//    }
//    public void update(Employee employee) {
//        try {
//            trans.begin();
//            em.merge(employee);
//            trans.commit();
//        } catch (Exception ex) {
//            trans.rollback();
//            logger.error(ex.getMessage());
//        }
//    }
//    public Optional<Employee> findbyId(long id) {
//        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.id=:id", Employee.class);
//        query.setParameter("id", id);
//        Employee emp = query.getSingleResult();
//        return emp == null ? Optional.empty() : Optional.of(emp);
//    }

    public List<Employee> getAll() {
        try {
            Session session = sessionFactory.openSession();
            trans = session.beginTransaction();
            List<Employee> lst = session.createNamedQuery("Employee.findAll",Employee.class)
                    .getResultList();
            trans.commit();
            return  lst;
        } catch (Exception ex) {
            trans.rollback();
            logger.error(ex.getMessage());
        }
        return null;
    }

    public boolean update(Employee employee) {
        try {
            Session session = sessionFactory.openSession();
            trans = session.beginTransaction();
            session.merge(employee);
            trans.commit();
            return  true;
        } catch (Exception ex) {
            trans.rollback();
            logger.error(ex.getMessage());
        }
        return false;
    }

    public boolean delete(long id) {
        Optional<Employee> employeeOptional = findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setStatus(EmployeeStatus.TERMINATED);
            return true;
        }
        return false;
    }

    public boolean activeEmp(long id) {
        Optional<Employee> op = findById(id);
        if (op.isPresent()) {
            Employee employee = op.get();
            employee.setStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }
    public Optional<Employee> findById(long id) {
        Session session = sessionFactory.openSession();
        trans = session.beginTransaction();
        Employee emp = session.createNamedQuery("Employee.findByID",Employee.class)
                .setParameter("id",id)
                .getSingleResult();
        trans.commit();
        return emp == null ? Optional.empty() : Optional.of(emp);
    }
//...

}
