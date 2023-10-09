package br.evelyn.barriga.domain;

import static br.evelyn.barriga.domain.builder.ContaBuilder.umaConta;
import static br.evelyn.barriga.domain.builder.UsuarioBuilder.umUsuario;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import br.evelyn.barriga.domain.exceptions.ValidationException;

public class ContaTest {
	
	@Test
	public void deveCriarContaValida() {
		//criar uma conta
		Conta conta = umaConta().agora();
		
		//Assertivas
		Assertions.assertAll("Conta", 
				() -> assertEquals(1L, conta.getId()),
				() -> assertEquals("Conta1", conta.getNome()),
				() -> assertEquals(umUsuario().agora(), conta.getUsuario())
		);
	}
	
	@ParameterizedTest
	@MethodSource (value = "dataProvider") //fonte de dados
	public void deveRejeitarContaInvalida(Long id, String nome, Usuario usuario, String mensagem) {
		String errorMessage = Assertions.assertThrows(ValidationException.class, () -> 
			umaConta().comId(id).comNome(nome).comUsuario(usuario).agora()).getMessage();
		Assertions.assertEquals(mensagem, errorMessage);
	}

	private static Stream<Arguments> dataProvider(){
		return Stream.of(
				Arguments.of(1L, null, umUsuario().agora(), "Nome é obrigatório"),
				Arguments.of(1L,"Conta1" ,null, "Usuário é obrigatório")
				
		);
	}
}
