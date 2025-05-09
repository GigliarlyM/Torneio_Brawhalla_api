package br.gigliarly.torneio_brawhalla_api.repository;

import br.gigliarly.torneio_brawhalla_api.entity.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Long> {
}
