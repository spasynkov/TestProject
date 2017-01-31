package net.ukrtel.ddns.ff.data;

import net.ukrtel.ddns.ff.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
