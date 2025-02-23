package com.brailprev.domain.jogo.repositories;
import com.brailprev.domain.jogo.entities.Propriedade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropriedadeRepository extends JpaRepository<Propriedade, Long> {
}