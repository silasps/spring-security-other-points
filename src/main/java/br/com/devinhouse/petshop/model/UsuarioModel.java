package br.com.devinhouse.petshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import java.util.List;

@Entity
@Getter
@Setter
public class UsuarioModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roel;

}
