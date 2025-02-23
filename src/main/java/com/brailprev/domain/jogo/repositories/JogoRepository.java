package com.brailprev.domain.jogo.repositories;

import com.brailprev.domain.jogo.entities.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
