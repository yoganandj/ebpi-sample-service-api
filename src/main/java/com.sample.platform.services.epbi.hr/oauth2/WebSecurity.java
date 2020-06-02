package com.sample.platform.services.ebpi.hr.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private RESTAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private RestAccessDeniedHandler accessDeniedHandler;

 /*   @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        UserDetails user= User.builder().username("user").password(passwordEncoder().encode("secret")).
                roles("USER").build();
        UserDetails userAdmin=User.builder().username("admin").password(passwordEncoder().encode("secret")).
                roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user,userAdmin);
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception{

      /*  http
                .cors().and()
                .csrf().disable().authorizeRequests()
                .antMatchers("/hr").hasRole("manager")
                .anyRequest().authenticated()
                .and()
                .formLogin();*/

        http
                .authorizeRequests()
                .antMatchers("/hr").hasRole("manager")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .realmName("restApp");

                /*.and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(authenticationEntryPoint);*/


    }
}
