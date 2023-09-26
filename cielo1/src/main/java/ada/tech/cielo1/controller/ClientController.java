package ada.tech.cielo1.controller;

import ada.tech.cielo1.client.Client;
import ada.tech.cielo1.client.ClientRepository;
import ada.tech.cielo1.client.ClientRequestDTO;
import ada.tech.cielo1.client.ClientResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/save")
    public void saveClient(@RequestBody ClientRequestDTO data) {
        Client clientData = new Client(data);
        repository.save(clientData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ClientResponseDTO> getAll() {
        List<ClientResponseDTO> clientsList = repository.findAll().stream().map(ClientResponseDTO::new).toList();
        return clientsList;
    }
}
