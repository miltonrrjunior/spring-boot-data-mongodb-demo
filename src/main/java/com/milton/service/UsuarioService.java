package com.milton.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.milton.entity.Usuario;
import com.milton.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario findById(String id) {
		return usuarioRepository.findById(id).get();
	}

	public void delete(String id) {
		usuarioRepository.deleteById(id);
	}

	public List<Usuario> listaUsuario() {
		return usuarioRepository.findAll();
	}

	public Page<Usuario> listaPaginada(int page, int count) {
		return usuarioRepository.findAll(PageRequest.of(page, count));
	}

	public List<Usuario> buscaPorNome(String nome) {
		return usuarioRepository.findByNomeLikeIgnoreCase(nome);
	}

}
