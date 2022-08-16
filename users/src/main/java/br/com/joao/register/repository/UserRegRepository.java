package br.com.joao.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joao.register.model.UserReg;

public interface UserRegRepository extends JpaRepository<UserReg, Long> {

}
