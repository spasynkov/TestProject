package net.ukrtel.ddns.ff.data;

import net.ukrtel.ddns.ff.domain.User;

public interface UsersRepository {
    User findOne(long id);
    User findByUsername(String username);
    User add(User user);
}
