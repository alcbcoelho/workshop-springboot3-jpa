package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	/*
	 Essa interface especificamente NÃO precisa de uma implementação. O Spring Data JPA (sub-framework de onde
	 está vindo a interface JpaRepository) já tem uma implementação padrão para essa interface, sendo necessário
	 apenas definir os generics para a entidade alvo e o tipo do id dela, como fizemos acima.
	 */
}
