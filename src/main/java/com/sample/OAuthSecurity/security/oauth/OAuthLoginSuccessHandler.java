package com.sample.OAuthSecurity.security.oauth;

import com.sample.OAuthSecurity.data.model.AppUser;
import com.sample.OAuthSecurity.data.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuthLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws ServletException, IOException {
        CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        String email = customOAuth2User.getEmail();
        String name = customOAuth2User.getName();
        if(!appUserRepository.existsByEmail(email)) {
            AppUser newUser = new AppUser(name, email);
            appUserRepository.save(newUser);
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
