package net.ukrtel.ddns.ff.data;

import net.ukrtel.ddns.ff.domain.User;
import net.ukrtel.ddns.ff.security.SecurityRoles;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersRepositoryImpl implements UsersRepository {
    private static long maxId = 0;
    private List<User> users = new ArrayList<User>();

    {
        // adding admin
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");

        List<SecurityRoles> roles = new ArrayList<SecurityRoles>();
        roles.add(SecurityRoles.USER);
        roles.add(SecurityRoles.ADMIN);
        admin.setRoles(roles);

        add(admin);
    }

    public User findOne(long id) {
        for (User user : users) {
            if (user.getId() == id) return user;
        }
        return null;
    }

    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) return user;
        }
        return null;
    }

    public User add(User user) {
        users.add(user);
        user.setId(maxId++);
        return user;
    }
}
