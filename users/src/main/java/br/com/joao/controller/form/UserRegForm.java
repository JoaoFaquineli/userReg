package br.com.joao.controller.form;

import br.com.joao.register.model.UserReg;

public class UserRegForm {

	private String name;
	private String email;
	private String password;

	public String getName() {
		return name;
	}

	public UserRegForm(String email, String senha, String name) {
		super();
		this.name = name;
		this.email = email;
		this.password = senha;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserReg convert(UserRegForm form) {
		return new UserReg(name, email, password);
	}

}
