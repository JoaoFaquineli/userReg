package br.com.joao.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.joao.controller.Dto.UserRegDto;
import br.com.joao.controller.form.UserRegForm;
import br.com.joao.register.model.UserReg;
import br.com.joao.register.repository.UserRegRepository;

@RestController
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserRegRepository userRegRepository;

	@GetMapping
	public List<UserRegDto> list(String name) {

		List<UserReg> usersReg = userRegRepository.findAll();
		return UserRegDto.convert(usersReg);
	}

	@PostMapping
	public ResponseEntity<UserRegDto> register(@RequestBody UserRegForm form, UriComponentsBuilder uriBuilder) {
		UserReg usersReg = form.convert(form);
		userRegRepository.save(usersReg);

		URI uri = uriBuilder.path("/users/{id}").buildAndExpand(usersReg.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserRegDto(usersReg));
	}

}
