package br.com.dev.eficiente.nosso.mercado.livre.dto;

import br.com.dev.eficiente.nosso.mercado.livre.repository.CategoryRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Validated
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @NotBlank
    private String name;

    @Setter
    private long motherCategoryId;

    public boolean validateMotherCategoryId(CategoryRepository repository){
        if(motherCategoryId==0)
            return true;
        return repository.findById(motherCategoryId).isPresent();
    }
}
