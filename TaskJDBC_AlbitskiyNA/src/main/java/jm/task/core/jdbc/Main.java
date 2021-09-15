package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService u1 = new UserServiceImpl();

        u1.createUsersTable();

        u1.saveUser("Dimas", "Konischev", (byte) 27);
        u1.saveUser("Ilya", "Trifon", (byte) 26);
        u1.saveUser("Antonio", "Votin", (byte) 28);
        u1.saveUser("Putin", "Vor", (byte) 99);

        List<User> list = u1.getAllUsers();
        for (User u : list) {
            System.out.println(u.toString());
        }

        u1.cleanUsersTable();

        u1.dropUsersTable();

        /*
        u1.saveUser("Dimas", "Konischev", (byte) 27);
        u1.saveUser("Ilya", "Trifon", (byte) 26);
        u1.saveUser("Antonio", "Votin", (byte) 28);
        u1.saveUser("Putin", "Vor", (byte) 99);
        u1.saveUser("Natalya", "Garmash", (byte) 50);
        u1.saveUser("Roman", "Kachanovskiy", (byte) 50);
        u1.saveUser("Alex", "Sosed", (byte) 45);
        u1.saveUser("Lera", "Konischeva", (byte) 28);

         */
    }
}
