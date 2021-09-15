package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // Данные дравера JDBC и пользователя MySQL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/kda_test?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "170101";

    // Подключение через JDBC
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Соединение с БД не установлено");
            e.printStackTrace();
        }
        return connection;
    }

    // Подключение через Hibernate
    protected SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;

        Properties prop = new Properties();
        prop.put(Environment.DRIVER, DRIVER);
        prop.put(Environment.URL, URL);
        prop.put(Environment.USER, USER);
        prop.put(Environment.PASS, PASS);
        //prop.put(Environment.CONNECTION_PROVIDER, "com.zaxxer.hikari.hibernate.HikariConnectionProvider");
        prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
        prop.put(Environment.SHOW_SQL, "true");
        prop.put(Environment.HBM2DDL_AUTO, "none");

        Configuration config = new Configuration();
        config.setProperties(prop);
        config.addAnnotatedClass(jm.task.core.jdbc.model.User.class);

        final ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();
        try {
            sessionFactory = config.buildSessionFactory(registry);
            System.out.println("SessionFactory - создан");
        } catch (Exception e) {
            System.out.println("SessionFactory - НЕ создан");
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
        return sessionFactory;
    }
}
