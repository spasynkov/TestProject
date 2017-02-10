package net.ukrtel.ddns.ff.services;

import net.ukrtel.ddns.ff.data.UsersRepository;
import net.ukrtel.ddns.ff.domain.SecurityRoles;
import net.ukrtel.ddns.ff.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService implements UserDetailsService {
    private UsersRepository usersRepository;

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(username);

        if (user != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (SecurityRoles role : user.getRoles()) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
            }

            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    authorities
            );
        }

        throw new UsernameNotFoundException("User '" + username + "' not found.");
    }

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }
}
