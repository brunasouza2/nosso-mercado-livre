package br.com.dev.eficiente.nosso.mercado.livre.controller;

import br.com.dev.eficiente.nosso.mercado.livre.dto.Category;
import br.com.dev.eficiente.nosso.mercado.livre.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository repository;

    @PostMapping(value = "/category")
    public ResponseEntity<String> addCategory(@RequestBody @Valid Category category){
        if(repository.findByName(category.getName()).isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nao foi possivel salvar uma categoria com este nome.");
        }

        if(!category.validateMotherCategoryId(repository)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("MotherCategoryId nao existe.");
        }
        repository.save(category);
        return ResponseEntity.ok("Categoria "+category.getName()+" criada com sucesso!");
    }
}
