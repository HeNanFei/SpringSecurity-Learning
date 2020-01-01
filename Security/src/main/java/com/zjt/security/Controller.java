package com.zjt.security;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @RequestMapping("/success")
    public String success(){
        //System.out.println("登录成功的用户"+getUserName());

        return "success";
    }

    @PreAuthorize("hasAuthority('p2')")
    @RequestMapping("/author/test")
    public String author(){

        return "author";

    }


    private static String getUserName(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return userDetails.getUsername();


    }


}
