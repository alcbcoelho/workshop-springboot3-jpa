package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_user")	// renomeando a tabela da entidade User p/ "tb_user" porque "User"
						// é uma palavra reservada do banco de dados H2
public class User implements Serializable {
	private static final long serialVersionUID = 1L;	// Serializable exige um número de série
	
	@Id		// indica se tratar da chave primária da entidade
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//	= AUTO_INCREMENT
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
//	private List<Order> orders;
	
	public User() {}	// é obrigado colocar construtores vazios no Spring
	
	public User(Long id, String name, String email, String phone, String password/*, List<Order> orders*/) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
//		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public List<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
