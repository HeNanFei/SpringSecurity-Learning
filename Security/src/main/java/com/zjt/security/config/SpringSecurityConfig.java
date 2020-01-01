package com.zjt.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;
@Component
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
   /* @Bean
    public UserDetailsService getUserDetail(){

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        inMemoryUserDetailsManager.createUser(User.withUsername("xiaoming").password("xiaoming").authorities("p2").build());
        inMemoryUserDetailsManager.
                createUser(User.withUsername("xiaozhang").password("xiaozhang").authorities("p11").build());
        return  inMemoryUserDetailsManager;


    }*/

    @Bean
    public PasswordEncoder getPwdEncoder(){




        return new BCryptPasswordEncoder();

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
       // .antMatchers("/author/**").hasAuthority("p2").antMatchers("/pri/**").authenticated()
        http.authorizeRequests().antMatchers("/author/**").authenticated()
                .anyRequest().permitAll().and().formLogin().loginPage("/login2").loginProcessingUrl("/login/test")
                .successForwardUrl("/success").and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);



    }
}
