package ada.tech.cielo1.infra.database.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCustomer extends JpaRepository<CustomerModel, UUID> {
    CustomerModel findByUuid(UUID uuid);
    CustomerModel findByEmail(String email);
    CustomerModel findByCpf(String cpf);
    void deleteByUuid(UUID uuid);
}
