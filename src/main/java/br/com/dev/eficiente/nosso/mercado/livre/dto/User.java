package br.com.dev.eficiente.nosso.mercado.livre.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User implements Serializable {

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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime instant;

    public User(@NotBlank @Email String login,
                @NotBlank @Length(min = 6) String password,
                @NotNull @Past @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") LocalDateTime instant){
        this.login = login;
        this.password = password;
        this.instant = instant;
    }
}
