package br.evelyn.barriga.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

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
	
	
	//ESTE SUBSTITUI OS 3 ACIMA:
	
//	@ParameterizedTest(name = "{index} - {4}") // {4} o quarto atributo iniciando com zero
//	@CsvSource(value = {
//			"1, NULL, user@email.com, 123456, Nome é obrigatório",
//			"1, Usuario1, NULL, 123456, E-mail é obrigatório",
//			"1, Usuario1, user@email.com, NULL, Senha é obrigatória"
//	}, nullValues = "NULL") 
//	public void deveValidarCamposObrigatorios(Long id, String nome, String email, String senha, String mensagem) {
//		ValidationException ex = Assertions.assertThrows(ValidationException.class, 
//				() -> UsuarioBuilder.umUsuario().comId(id).comNome(nome).comEmail(email).comSenha(senha).agora());
//		Assertions.assertEquals(mensagem, ex.getMessage());
//	}
	
	
//	@ParameterizedTest(name = "{index} - {4}") // {4} o quarto atributo iniciando com zero
//	@CsvFileSource(files = "src\\test\\resources\\camposObrigatoriosUsuarios.csv", nullValues = "NULL", numLinesToSkip = 1)
	
	@ParameterizedTest
	@CsvFileSource(files = "src\\test\\resources\\camposObrigatoriosUsuarios.csv", nullValues = "NULL",useHeadersInDisplayName = true)
	public void deveValidarCamposObrigatorios(Long id, String nome, String email, String senha, String mensagem) {
		ValidationException ex = Assertions.assertThrows(ValidationException.class, 
				() -> UsuarioBuilder.umUsuario().comId(id).comNome(nome).comEmail(email).comSenha(senha).agora());
		Assertions.assertEquals(mensagem, ex.getMessage());
	}
}
