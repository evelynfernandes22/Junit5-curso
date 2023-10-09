package br.evelyn.barriga.infra;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.evelyn.barriga.domain.Usuario;
import br.evelyn.barriga.service.repositories.UsuarioRepository;

public class UserMemoryRepository  implements UsuarioRepository{

	private List<Usuario> users;
	private Long currentId;
	
	
	public UserMemoryRepository() {
		this.currentId = 0L;
		this.users = new ArrayList<>();
		salvar(new Usuario(null, "User#1","user1@email.com", "123"));
	}

	@Override
	public Usuario salvar(Usuario usuario) {
		Usuario novoUsuario = new Usuario(nextId(), usuario.getNome(), 
				usuario.getEmail(), usuario.getSenha());
		users.add(novoUsuario);
		return novoUsuario;
	}

	@Override
	public Optional<Usuario> getUserByEmail(String email) {
		
		return users.stream()
				.filter(user -> user.getEmail().equalsIgnoreCase(email))
				.findFirst();
	}

	private Long nextId() {
		return ++currentId;
	}
	
	public void printUsers() {
		System.out.println(users);
	}
	
	public static void main(String[] args) {
		UserMemoryRepository memoryRepository = new UserMemoryRepository();
		memoryRepository.printUsers();
		
		memoryRepository.salvar(new Usuario(null,"user#2" , "user2@email.com", "abc"));
		memoryRepository.printUsers();
		
		memoryRepository.salvar(new Usuario(null, null , "user2@email.com", "abc"));
		memoryRepository.printUsers();
	}
}
