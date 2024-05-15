package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

// CLASSE DE CONFIGURAÇÃO ESPECÍFICA PARA O PERFIL DE TESTE (TEST PROFILE)
// - para popular nosso banco de dados com alguns objetos (database seeding)

@Configuration		// indica que essa é uma classe específica de configuração
@Profile("test")	// indica que a configuração é específica para o perfil de teste/test profile
					// (o parâmetro deve ter o mesmo nome da propriedade 'spring.profiles.active'
					// do arquivo application.properties)
public class TestConfig implements CommandLineRunner /* interface que fará com que essa configuração 
rode assim que a aplicação rodar */ {

	@Autowired	// mecanismo de injeção de dependência do Spring; associará uma instância de UserRepository
				// aqui dentro
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "98888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "97777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	// 👆 tudo colocado dentro desse método será executado quando a aplicação for iniciada
}
