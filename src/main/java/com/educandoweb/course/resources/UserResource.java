package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController // indica que é um recurso web que é implementado por um controlador REST
@RequestMapping(value="/users")
public class UserResource {
	@Autowired
	UserService service;
	
	@GetMapping // indica se tratar de um método que responde uma requisição GET
//	ResponseEntity: tipo específico do Spring para retornar respostas de requisições web
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")	// indica que a requisição aceitará a especificação de um parâmetro
									// dentro da URL (neste caso, referente ao ID a ser resgatado)
	public ResponseEntity<User> findById(@PathVariable /*
	indica que o parâmetro seguinte está vinculado ao parâmetro de URL
	especificado no @GetMapping acima (são o mesmo parâmetro, resumidamente)
	*/ Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
