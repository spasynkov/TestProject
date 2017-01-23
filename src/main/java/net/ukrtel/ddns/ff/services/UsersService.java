package net.ukrtel.ddns.ff.services;

import net.ukrtel.ddns.ff.data.UsersRepository;
import net.ukrtel.ddns.ff.domain.User;
import net.ukrtel.ddns.ff.security.SecurityRoles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UsersService implements UserDetailsService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(username);

        if (user != null) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            for (SecurityRoles roles : user.getRoles()) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + roles.name()));
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
        return usersRepository.getAll();
    }
}
