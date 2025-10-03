package com.lifemanagement.reflect.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    private String fullName;
    private String password;
    private String role;

}

