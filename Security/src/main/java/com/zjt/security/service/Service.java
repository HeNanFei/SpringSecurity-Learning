package com.zjt.security.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@org.springframework.stereotype.Service
public class Service implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


        System.out.println("接收的用户名"+s);
        UserDetails build2 = User.withUsername("zjt").password("$2a$10$kCN9r5pqPt0zIIE5C9GbMuTaLJd7p3IzAKRDtpA.qx7zNkljx5TF2").authorities("p1").build();

     UserDetails build = User.withUsername("wangwu").password("$2a$10$kCN9r5pqPt0zIIE5C9GbMuTaLJd7p3IzAKRDtpA.qx7zNkljx5TF2").authorities("p2").build();
        return build2;
    }
}
