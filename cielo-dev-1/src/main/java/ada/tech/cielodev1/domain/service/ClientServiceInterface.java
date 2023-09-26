package ada.tech.cielodev1.domain.service;

import ada.tech.cielodev1.domain.model.Client;

import java.util.List;
import java.util.UUID;

public interface ClientServiceInterface {
    Client create(Client client);
    Client update(Client client);
    Client deleteById(UUID id);
    Client findById(UUID id);
    List<Client> getAllClients();
}
