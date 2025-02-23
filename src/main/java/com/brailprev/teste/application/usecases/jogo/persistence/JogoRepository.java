package com.brailprev.teste.application.usecases.jogo.persistence;

import com.brailprev.teste.application.usecases.jogo.entities.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
