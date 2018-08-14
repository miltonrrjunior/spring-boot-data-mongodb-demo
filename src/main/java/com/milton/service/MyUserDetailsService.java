package com.milton.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.milton.config.MyUserDetails;
import com.milton.entity.Usuario;
import com.milton.repository.UsuarioRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private final UsuarioRepository userRepository;

	@Autowired
	public MyUserDetailsService(UsuarioRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = userRepository.findByEmail(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(String.format("Usuário não existe!", username));
		}
		return new MyUserDetails(usuario);
	}

}
