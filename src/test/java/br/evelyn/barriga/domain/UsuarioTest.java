package br.evelyn.barriga.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

import br.evelyn.barriga.domain.builders.UsuarioBuilder;
import br.evelyn.barriga.domain.exceptions.ValidationException;

public class UsuarioTest {

	@Test
	@DisplayName("Deve criar um usuário válido")
	public void deveCriarUsuarioValido() {
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Assertions.assertAll("Usuario",
				() -> assertEquals(1L, usuario.getId()),
				() -> assertEquals("Usuario1", usuario.getNome()),
				() -> assertEquals("user@email.com", usuario.getEmail()),
				() -> assertEquals("123456", usuario.getSenha())
		);
		
	}
	
	@Test
	public void deveRejeitarUsuarioSemNome() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class,
				() -> UsuarioBuilder.umUsuario().comNome(null).agora());
		assertEquals("Nome é obrigatório", ex.getMessage());
	}
	
	@Test
	public void deveRejeitarUsuarioSemEmail() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, 
				() -> UsuarioBuilder.umUsuario().comEmail(null).agora());
				assertEquals("E-mail é obrigatório", ex.getMessage());
	}
	
	@Test
	public void deveRejeitarUsuarioSemSenha() {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, 
				() -> UsuarioBuilder.umUsuario().comSenha(null).agora());
		Assertions.assertEquals("Senha é obrigatória", ex.getMessage());
	}
}
