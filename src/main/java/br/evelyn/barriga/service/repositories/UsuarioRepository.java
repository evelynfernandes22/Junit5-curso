package br.evelyn.barriga.service.repositories;

import java.util.Optional;

import br.evelyn.barriga.domain.Usuario;

public interface UsuarioRepository {

	Usuario salvar(Usuario usuario);
	
	Optional<Usuario> getUserByEmail(String email);
}
