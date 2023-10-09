package br.evelyn.barriga.infra;

import java.util.Optional;

import br.evelyn.barriga.domain.Usuario;
import br.evelyn.barriga.domain.builder.UsuarioBuilder;
import br.evelyn.barriga.service.repositories.UsuarioRepository;

public class UsuarioDummyRepository implements UsuarioRepository{
	

	@Override
	public Usuario salvar(Usuario usuario) {
		return UsuarioBuilder.umUsuario()
				.comNome(usuario.getNome())
				.comEmail(usuario.getEmail())
				.comSenha(usuario.getSenha())
				.agora();
	}

	@Override
	public Optional<Usuario> getUserByEmail(String email) {
		if("user@email.com".equals(email))
			return Optional.of(UsuarioBuilder.umUsuario().comEmail(email).agora());
		return Optional.empty();
	}

}
