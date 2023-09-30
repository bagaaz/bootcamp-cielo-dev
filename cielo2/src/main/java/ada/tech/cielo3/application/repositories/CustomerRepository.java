package ada.tech.cielo3.application.repositories;

import ada.tech.cielo3.domain.entities.Customer;

import java.util.UUID;

public interface CustomerRepository {
    Customer findById(UUID uuid);
    Customer findByEmail(String email);
    Customer findByCpf(String cpf);
    void save(Customer customer);
    void update(Customer customer);
    void delete(UUID uuid);
}
