import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService us1 = new UserServiceImpl();

        us1.createUsersTable();

        us1.saveUser("Dimas", "Konischev", (byte) 27);
        us1.saveUser("Antonio", "Votin", (byte) 28);
        us1.saveUser("Ilya", "Trifon", (byte) 26);
        us1.saveUser("Putin", "Vor", (byte) 99);

        for (jm.task.core.jdbc.model.User user : us1.getAllUsers()) {
            System.out.println(user);
        }

        us1.cleanUsersTable();

        us1.dropUsersTable();
    }
}