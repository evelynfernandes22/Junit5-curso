package br.evelyn.barriga.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.evelyn.barriga.domain.Usuario;
import br.evelyn.barriga.domain.builder.UsuarioBuilder;
import br.evelyn.barriga.infra.UsuarioDummyRepository;

public class UsuarioServiceTest {

	private UsuarioService service;
	
	@Test
	public void deveSalvarUsuarioComSucesso() {
		service = new UsuarioService(new UsuarioDummyRepository());
		Usuario user = UsuarioBuilder.umUsuario().comId(null).comEmail("outro@email.com").agora();
		Usuario saverUser = service.salvar(user);
		Assertions.assertNotNull(saverUser.getId());
	}
}
