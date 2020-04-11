package br.com.dev.eficiente.nosso.mercado.livre.dto;

import br.com.dev.eficiente.nosso.mercado.livre.util.CryptPassword;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDateTime;

@Entity
@Validated
@Table(name = "user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Email
    @NotBlank
    private String login;

    @NotBlank
    @Length(min = 6)
    private String password;

    @NotNull
    @Past
    private LocalDateTime instant;

    public User(@NotBlank @Email String login,
                @NotBlank @Length(min = 6) String password){
        this.login = login;
        this.password = new CryptPassword().encode(password);
        this.instant = LocalDateTime.now();
    }
}
