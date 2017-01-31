package net.ukrtel.ddns.ff.config;

import net.ukrtel.ddns.ff.security.SecurityRoles;
import net.ukrtel.ddns.ff.services.UsersService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/me", "/applications/**").hasRole(SecurityRoles.USER.name())
                    .antMatchers("/admin/**").hasRole(SecurityRoles.ADMIN.name())
                    .anyRequest().permitAll()

                .and()
                .formLogin()//.loginPage("/login").successForwardUrl("/me")

                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UsersService());
    }
}
