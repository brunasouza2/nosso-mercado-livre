package br.com.dev.eficiente.nosso.mercado.livre.repository;

import br.com.dev.eficiente.nosso.mercado.livre.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}