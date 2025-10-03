package com.lifemanagement.reflect.service;


import com.lifemanagement.reflect.entity.AppUser;
import com.lifemanagement.reflect.repository.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthSerivce {
    private final AuthenticationManager manager;

    private final PasswordEncoder passwordEncoder;
    private final AppUserRepo appUserRepo;
    public void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }
    }

    public void signup(String fullName, String email, String password){

        try{
            AppUser user = AppUser.builder().fullName(fullName).email(email).password(passwordEncoder.encode(password)).role("USER").build();

            if (appUserRepo.findByEmail(email).isPresent()){
                throw new RuntimeException("User already exists");


            }
            else{
                appUserRepo.save(user);
                try{
                    doAuthenticate(email, password);
                }
                catch (Exception e){
                    throw  new RuntimeException(""+e);
                }
            }


        }
        catch (Exception e){
            throw new RuntimeException("Exception: "+e);
        }


    }
}
