package ada.tech.cielodev1.domain.service;

import ada.tech.cielodev1.domain.model.Client;
import ada.tech.cielodev1.port.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService implements ClientServiceInterface {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client create(Client client) {
        //Verifica se todos os dados foram informados, se não, retorna um status code informando que faltam dados = 400
        //Verifica se o cliente já existe, se sim, retorna um status code informando que o cliente já existe = 409
        // Aqui vai a lógica de criação de um cliente
        return client;
    }

    @Override
    public Client update(Client client) {
        //Verifica se todos os dados foram informados, se não, retorna um status code informando que faltam dados = 400
        //Verifica se o cliente já existe, se não, retorna um status code informando que o cliente não existe = 404
        // Aqui vai a lógica de atualização de um cliente
        return client;
    }

    @Override
    public Client deleteById(UUID id) {
        //Verifica se o cliente já existe, se não, retorna um status code informando que o cliente não existe = 404
        // Aqui vai a lógica de exclusão de um cliente
        return null;
    }

    @Override
    public Client findById(UUID id) {
        //Verifica se o cliente já existe, se não, retorna um status code informando que o cliente não existe = 404
        // Aqui vai a lógica de busca de um cliente
        return null;
    }
}
