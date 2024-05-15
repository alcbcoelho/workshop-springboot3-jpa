package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController // indica que é um recurso web que é implementado por um controlador REST
@RequestMapping(value="/users")
public class UserResource {

	@GetMapping // indica se tratar de um método que responde uma requisição GET
//	ResponseEntity: tipo específico do Spring para retornar respostas de requisições web
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
