package br.com.dev.eficiente.nosso.mercado.livre.controller;

import br.com.dev.eficiente.nosso.mercado.livre.dto.User;
import br.com.dev.eficiente.nosso.mercado.livre.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping(value = "/user")
    public ResponseEntity<String> addUser(@Valid @RequestParam String login, @Valid @RequestParam String password){
        repository.save(new User(login, password));
        return ResponseEntity.ok("Usuario "+login+" criado com sucesso!");
    }
}
