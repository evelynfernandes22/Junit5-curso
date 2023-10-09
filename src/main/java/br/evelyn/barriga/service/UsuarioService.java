package br.evelyn.barriga.service;

import br.evelyn.barriga.domain.Usuario;
import br.evelyn.barriga.domain.exceptions.ValidationException;
import br.evelyn.barriga.service.repositories.UsuarioRepository;

public class UsuarioService {
	
	private UsuarioRepository repository;
	
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	
	public Usuario salvar(Usuario usuario) {
		repository.getUserByEmail(usuario.getEmail()).ifPresent(user -> {
			throw new ValidationException(String.format("Usuário %s já cadastrado", usuario.getEmail()));
		});
		return repository.salvar(usuario);
	}
	
	
}
