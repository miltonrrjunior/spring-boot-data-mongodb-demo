package com.milton.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.milton.entity.Perfil;
import com.milton.entity.Usuario;
import com.milton.repository.PerfilRepository;
import com.milton.repository.UsuarioRepository;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PerfilRepository perfilRepository;

	@Bean
	public PasswordEncoder passwordEncoderBean() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent e) {

		List<Perfil> perfis = perfilRepository.findAll();

		if (perfis.isEmpty()) {
			perfilRepository.save(new Perfil("ROLE_ADMIN"));
			perfilRepository.save(new Perfil("ROLE_USER"));

			Perfil perfil = perfilRepository.findByNome("ROLE_ADMIN");

			List<Perfil> novosPerfis = new ArrayList<>();

			novosPerfis.add(perfil);

			usuarioRepository.save(new Usuario("ADMIN", "admin", passwordEncoderBean().encode("123"), novosPerfis));

		}

	}

}
