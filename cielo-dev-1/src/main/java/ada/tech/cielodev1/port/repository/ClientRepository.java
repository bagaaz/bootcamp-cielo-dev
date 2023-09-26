package ada.tech.cielodev1.port.repository;

import ada.tech.cielodev1.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    boolean existsByUuid(UUID uuid);
}
