package com.milton.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.milton.entity.Perfil;

@Repository
public interface PerfilRepository extends MongoRepository<Perfil, String> {

}
