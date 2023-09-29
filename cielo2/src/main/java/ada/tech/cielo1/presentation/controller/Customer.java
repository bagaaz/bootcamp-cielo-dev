package ada.tech.cielo1.presentation.controller;

import ada.tech.cielo1.application.dtos.*;
import ada.tech.cielo1.application.usecases.DeleteCustomer;
import ada.tech.cielo1.application.usecases.GetCustomer;
import ada.tech.cielo1.application.usecases.RegisterCustomer;
import ada.tech.cielo1.application.usecases.UpdateCustomer;
import ada.tech.cielo1.infra.database.repository.JpaCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class Customer {

    @Autowired
    JpaCustomerRepository repository = new JpaCustomerRepository();

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{uuid}")
    public OutputGetCustomerDTO getCustomer(@PathVariable UUID uuid) {
        GetCustomer customer = new GetCustomer(repository);
        InputGetCustomerDTO input = new InputGetCustomerDTO(uuid);
        return customer.execute(input);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OutputRegisterCustomerDTO registerCustomer(@RequestBody InputRegisterCustomerDTO data) {
        RegisterCustomer registerCustomer = new RegisterCustomer(repository);
        return registerCustomer.execute(data);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PatchMapping ("/{uuid}")
    public void updateCustomer(@PathVariable UUID uuid, @RequestBody InputUpdateCustomerDTO data) {
        UpdateCustomer updateCustomer = new UpdateCustomer(repository);
        InputUpdateCustomerDTO input = new InputUpdateCustomerDTO(uuid, data.fullName(), data.cpf(), data.email(), data.merchantCategoryCode(), data.companyCnpj(), data.companyName());
        updateCustomer.execute(input);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID uuid) {
        DeleteCustomer deleteCustomer = new DeleteCustomer(repository);
        InputDeleteCustomerDTO input = new InputDeleteCustomerDTO(uuid);
        deleteCustomer.execute(input);
    }
}
