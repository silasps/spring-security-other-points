package br.com.devinhouse.petshop.repository;

import br.com.devinhouse.petshop.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    @Query("select u from UsuarioModel u where u.username = ?1")
    UsuarioModel findUserByUsername(String username);

}
