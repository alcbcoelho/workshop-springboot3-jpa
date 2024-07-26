package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service	// Annotation p/ registrar essa classe como um componente
			// do tipo Service. O registro de componentes Spring é necessário para
			// fazer com que a classe possa sofrer injeção de dependência*
// NOTA: A annotation @Component também poderia ser utilizada para este fim,
// mas para componentes de uma forma geral (não necessariamente um componente do
// tipo Service). Optou-se por usar @Service aqui só para ficar mais semanticamente
// específico mesmo.
//
// *: Entretanto, para repositories que implementam a interface JpaRepository,
// o uso da annotation p/ registro de componente Spring NÃO É NECESSÁRIO, pois essa
// interface já tem um registro de componente Spring
public class UserService {
	@Autowired
	private UserRepository repository;
	
	// Para este método, a camada de serviço apenas acessará o método CRUD
	// de leitura de dados do UserRepository
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);	// Tipo Optional: retorna ou não um usuário
		return obj.get();	// Optional.get(): referencia o usuário retornado, se ele existe
	}
}
