package com.orderservice.order.config;

import com.orderservice.order.service.GroupUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig  {

    @Autowired
    private GroupUserDetailService groupUserDetailsService;

//AUTHENTICATION
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(groupUserDetailsService);
    }

//AUTHORIZATION
    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

       http.

                csrf().
                disable().authorizeRequests()
               .antMatchers("/user/join").permitAll().and().authorizeRequests()
               .antMatchers("/user/**","/post/**").authenticated().and().httpBasic();
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   /* @Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationFilter();
    }*/

}
