package com.milton.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.milton.entity.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	List<Usuario> findByNomeLikeIgnoreCase(String nome);

	Usuario findByEmail(String email);

}
