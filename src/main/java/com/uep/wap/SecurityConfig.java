package com.uep.wap;

import com.uep.wap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserService userService;
    private final Encoder encoder;

    private static final String[] AUTH_WHITELIST = {
            "/userController/registerUser",
            "/auctionController/getAuctions",
            "/auctionController/auction/**",
            "/pico/css/**"
    };


    public SecurityConfig(UserService userService, Encoder encoder) {
        this.userService = userService;
        this.encoder = encoder;

    }

    @Autowired
    public void configureGlobal() {
        DaoAuthenticationProvider daoAuth = new DaoAuthenticationProvider();
        daoAuth.setUserDetailsService(userService);
        daoAuth.setPasswordEncoder(encoder.passwordEncoder());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().sameOrigin();

        http.authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        http.httpBasic();

        return http.build();
    }
}