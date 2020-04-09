package br.com.dev.eficiente.nosso.mercado.livre.controller;

import br.com.dev.eficiente.nosso.mercado.livre.dto.User;
import br.com.dev.eficiente.nosso.mercado.livre.repository.UserRepository;
import br.com.dev.eficiente.nosso.mercado.livre.util.CryptPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping(value = "/user")
    public ResponseEntity<String> addUser(@RequestParam String login, @RequestParam String password,
                                          @RequestParam("instant")  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime instant) {
        String passwordEncoded = new CryptPassword().encode(password);
        repository.save(new User(login, passwordEncoded, instant));
        return ResponseEntity.ok("Usuario "+login+" criado com sucesso!");
    }
}
