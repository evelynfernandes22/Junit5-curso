package br.evelyn.barriga.domain.builders;

import br.evelyn.barriga.domain.Usuario;

public class UsuarioBuilderOld {
	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private UsuarioBuilderOld() {}
	
	public static UsuarioBuilderOld umUsuario() {
		UsuarioBuilderOld builder = new UsuarioBuilderOld();
		InicializarDadosPadroes(builder);
		return builder;
	}

	private static void InicializarDadosPadroes(UsuarioBuilderOld builder) {
		builder.id = 1L;
		builder.nome = "Usuario1";
		builder.email = "user@email.com";
		builder.senha = "123";
	}
	
	public UsuarioBuilderOld comId(Long param) {
		id = param;
		return this;
	}
	
	public UsuarioBuilderOld comNome (String param) {
		nome = param;
		return this;
	}
	
	public UsuarioBuilderOld comEmail (String param) {
		email = param;
		return this;
	}
	
	public UsuarioBuilderOld comSenha (String param) {
		senha = param;
		return this;
	}
	
	public Usuario agora() {
		return new Usuario(id, nome, email, senha);
	}
}
