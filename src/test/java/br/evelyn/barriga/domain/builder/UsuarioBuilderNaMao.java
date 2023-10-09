package br.evelyn.barriga.domain.builder;

import br.evelyn.barriga.domain.Usuario;

public class UsuarioBuilderNaMao {
	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private UsuarioBuilderNaMao() {}
	
	public static UsuarioBuilderNaMao umUsuario() {
		UsuarioBuilderNaMao builder = new UsuarioBuilderNaMao();
		InicializarDadosPadroes(builder);
		return builder;
	}

	private static void InicializarDadosPadroes(UsuarioBuilderNaMao builder) {
		builder.id = 1L;
		builder.nome = "Usuario1";
		builder.email = "user@email.com";
		builder.senha = "123";
	}
	
	public UsuarioBuilderNaMao comId(Long param) {
		id = param;
		return this;
	}
	
	public UsuarioBuilderNaMao comNome (String param) {
		nome = param;
		return this;
	}
	
	public UsuarioBuilderNaMao comEmail (String param) {
		email = param;
		return this;
	}
	
	public UsuarioBuilderNaMao comSenha (String param) {
		senha = param;
		return this;
	}
	
	public Usuario agora() {
		return new Usuario(id, nome, email, senha);
	}
}
