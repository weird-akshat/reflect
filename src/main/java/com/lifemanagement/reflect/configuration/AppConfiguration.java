package com.lifemanagement.reflect.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration

public class AppConfiguration {

    @public UserDetailsService userDetailsService(){
        UserDetails = User.builder().username()
    }
}
