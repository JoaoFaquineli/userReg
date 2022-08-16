package br.com.joao.controller.Dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.joao.register.model.UserReg;

public class UserRegDto {

	private Long id;

	private String name;
	private LocalDateTime dataCriacao;
	private String email;
	private String password;

	public UserRegDto(UserReg userReg) {
		this.id = userReg.getId();
		this.email = userReg.getEmail();
		this.password = userReg.getPassword();
		this.dataCriacao = userReg.getDataCriacao();
		this.name = userReg.getName();
	}

	public UserRegDto(Long id, String name, LocalDateTime dataCriacao, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.dataCriacao = dataCriacao;
		this.email = email;
		this.password = password;
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

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static List<UserRegDto> convert(List<UserReg> userReg) {
		return userReg.stream().map(UserRegDto::new).collect(Collectors.toList());
	}

}
