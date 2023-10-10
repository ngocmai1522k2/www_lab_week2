package vn.edu.iuh.fit.backend.configs.connection;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionDB {
    private static ConnectionDB instance;
    private EntityManagerFactory emf;
    public ConnectionDB() {
        emf = Persistence.createEntityManagerFactory("week3_lab");
    }
    public static ConnectionDB getInstance() {
        if(instance == null)
            instance = new ConnectionDB();
        return instance;
    }
    public EntityManagerFactory getEmf() {
        return emf;
    }
}
