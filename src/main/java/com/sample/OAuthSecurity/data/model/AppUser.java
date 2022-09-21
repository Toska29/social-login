package com.sample.OAuthSecurity.data.model;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String email;
    private String name;

    @ElementCollection
    private Set<String> roles = new HashSet<>(Arrays.asList("Admin", "User"));

    public AppUser(String name, String email){
        this.name = name;
        this.email = email;
    }
}
