package br.com.devinhouse.petshop.service;

import br.com.devinhouse.petshop.model.UsuarioModel;
import br.com.devinhouse.petshop.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioModel> getAll() {
        return this.repository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioModel user = this.repository.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("usuário não encontrado");
        }

        return new User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }
}
