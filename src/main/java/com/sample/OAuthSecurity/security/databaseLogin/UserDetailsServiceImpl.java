package com.sample.OAuthSecurity.security.databaseLogin;

import com.sample.OAuthSecurity.data.model.AppUser;
import com.sample.OAuthSecurity.data.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(username);
        if(appUser == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new MyAppUserDetails(appUser);
    }
}
