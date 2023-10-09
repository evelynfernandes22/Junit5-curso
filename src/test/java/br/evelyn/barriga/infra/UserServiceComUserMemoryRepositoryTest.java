package br.evelyn.barriga.infra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.evelyn.barriga.domain.Usuario;
import br.evelyn.barriga.domain.builder.UsuarioBuilder;
import br.evelyn.barriga.domain.exceptions.ValidationException;
import br.evelyn.barriga.service.UsuarioService;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceComUserMemoryRepositoryTest {

	private static UsuarioService service = new UsuarioService(new UserMemoryRepository());
	
	@Test
	@Order(1)
	public void deveSalvarUsuarioValido() {
		Usuario user = service.salvar(UsuarioBuilder.umUsuario().agora());
		Assertions.assertNotNull(user.getId());
//		Assertions.assertEquals(2L, user.getId());
	}
	
//	@Test
//	public void deveSalvarUsuarioValido2() {
//		Usuario user = service.salvar(UsuarioBuilder.umUsuario().comId(null).comEmail("aa@email.com").agora());
//		Assertions.assertNotNull(user.getId());
//		Assertions.assertEquals(3L, user.getId());
//	}
	
	@Test
	@Order(2)
	public void deveRejeitarUsuarioExistente() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, () -> 
		service.salvar(UsuarioBuilder.umUsuario().agora()));
		Assertions.assertEquals("Usuário user@email.com já cadastrado" , ex.getMessage());
	}
}
