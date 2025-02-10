package com.brailprev.teste.infrastructure.persistence;

import com.brailprev.teste.domain.entities.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
