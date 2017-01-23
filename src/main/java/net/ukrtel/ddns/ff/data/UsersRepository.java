package net.ukrtel.ddns.ff.data;

import net.ukrtel.ddns.ff.domain.User;

import java.util.List;

public interface UsersRepository {
    User findOne(long id);
    User findByUsername(String username);
    User add(User user);
    List<User> getAll();
}
