package com.vcs.easybank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeHttpRequests()
                .requestMatchers("/myAccount", "/myBalance", "/myLoan", "myLoan").authenticated()
                .requestMatchers("/register", "/contact", "/notices").permitAll();
        http.formLogin();
        http.httpBasic();
        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//
//        // Approach 1 - defining multiple users
////        UserDetails user1 = User.withDefaultPasswordEncoder()
////                .username("admin")
////                .password("admin")
////                .authorities("admin")
////                .build();
////        UserDetails user2 = User.withDefaultPasswordEncoder()
////                .username("vcs01")
////                .password("vcs01")
////                .authorities("user")
////                .build();
//
//        // Approach 2 - with NoOpPasswordEncoder using withUsername()
//        UserDetails user1 = User.withUsername("admin")
//                .password("admin")
//                .authorities("admin")
//                .build();
//        UserDetails user2 = User.withUsername("vcs01")
//                .password("vcs01")
//                .authorities("user")
//                .build();
//        return new InMemoryUserDetailsManager(user1, user2);
//    }

//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
