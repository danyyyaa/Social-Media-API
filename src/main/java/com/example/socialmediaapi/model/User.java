package com.example.socialmediaapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="user_name")
    @NotBlank
    private String username;

    @Column(name="email")
    @Email
    @NotBlank
    private String email;

    @Column(name="password")
    @NotBlank
    private String password;

    /*@ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;*/
}