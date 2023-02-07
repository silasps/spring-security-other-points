package br.com.devinhouse.petshop.repository;

import br.com.devinhouse.petshop.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository extends JpaRepository<UsuarioModel, Long> {



}
