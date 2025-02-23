package br.gigliarly.torneio_brawhalla_api.repository;

import br.gigliarly.torneio_brawhalla_api.entity.Torneio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneioRepository extends JpaRepository<Torneio, Long> {
}
