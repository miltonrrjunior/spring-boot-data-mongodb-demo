package com.milton.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.milton.entity.Perfil;
import com.milton.service.PerfilService;

@RestController
public class PerfilController {

	@Autowired
	PerfilService perfilService;

	@RequestMapping(value = "/perfil", method = RequestMethod.POST)
	public Perfil salvar(@RequestBody Perfil usuario) {
		return this.perfilService.save(usuario);
	}

	@RequestMapping(value = "/perfil", method = RequestMethod.PUT)
	public Perfil editar(@RequestBody Perfil perfil) {
		return this.perfilService.save(perfil);
	}

	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		this.perfilService.delete(id);
	}

	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public List<Perfil> listaPerfil() {
		return this.perfilService.listaPerfil();
	}

	@RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
	public Perfil findById(@PathVariable String id) {
		return this.perfilService.findById(id);
	}

	@RequestMapping(value = "/perfil/{page}/{count}", method = RequestMethod.GET)
	public Page<Perfil> listaPaginada(@PathVariable int page, @PathVariable int count) {
		return this.perfilService.listaPaginada(page, count);
	}

}
