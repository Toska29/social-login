package com.sample.OAuthSecurity.data.repository;

import com.sample.OAuthSecurity.data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    AppUser findByEmail(String email);

    boolean existsByEmail(String email);
}
