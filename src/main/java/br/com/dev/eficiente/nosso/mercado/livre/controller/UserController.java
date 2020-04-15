package br.com.dev.eficiente.nosso.mercado.livre.controller;

import br.com.dev.eficiente.nosso.mercado.livre.dto.User;
import br.com.dev.eficiente.nosso.mercado.livre.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@Validated
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping(value = "/user")
    public ResponseEntity<String> addUser(@Valid @RequestParam String login, @Valid @RequestParam String password){
        if(repository.findByLogin(login).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nao foi possivel salvar um usuario com este email.");
        }
        repository.save(new User(login, password));
        return ResponseEntity.ok("Usuario "+login+" criado com sucesso!");
    }
}
