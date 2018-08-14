package com.milton.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.milton.entity.Perfil;
import com.milton.repository.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	PerfilRepository perfilRepository;

	public Perfil save(Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	public Perfil findById(String id) {
		return perfilRepository.findById(id).get();
	}

	public void delete(String id) {
		perfilRepository.deleteById(id);
	}

	public List<Perfil> listaPerfil() {
		return perfilRepository.findAll();
	}

	public Page<Perfil> listaPaginada(int page, int count) {
		return perfilRepository.findAll(PageRequest.of(page, count));
	}

}
