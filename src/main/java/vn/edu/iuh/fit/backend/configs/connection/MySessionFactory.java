package vn.edu.iuh.fit.backend.configs.connection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import vn.edu.iuh.fit.backend.configs.models.*;

public class MySessionFactory {
    private static MySessionFactory instance=null;
    private SessionFactory sessionFactory = null;
    public MySessionFactory(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderDetail.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(ProductImage.class)
                .addAnnotatedClass(ProductPrice.class)
                .getMetadataBuilder().build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static MySessionFactory getInstance(){
        if(instance == null){
            instance = new MySessionFactory();
        }
        return instance;
    }
}
