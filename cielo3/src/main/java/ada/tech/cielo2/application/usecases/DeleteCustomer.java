package ada.tech.cielo2.application.usecases;

import ada.tech.cielo2.application.dtos.InputDeleteCustomerDTO;
import ada.tech.cielo2.application.repositories.CustomerRepository;
import ada.tech.cielo2.domain.entities.Customer;
import ada.tech.cielo2.exceptions.NotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteCustomer {

    public CustomerRepository customerRepository;

    public void execute(InputDeleteCustomerDTO input) {
        Customer customer = customerRepository.findById(input.uuid());
        if (customer == null) throw new NotFoundException("Customer");
        customerRepository.delete(input.uuid());
    }
}
