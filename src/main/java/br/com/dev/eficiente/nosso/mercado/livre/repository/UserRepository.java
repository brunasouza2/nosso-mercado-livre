package br.com.dev.eficiente.nosso.mercado.livre.repository;

import br.com.dev.eficiente.nosso.mercado.livre.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
