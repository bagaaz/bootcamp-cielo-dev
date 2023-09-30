package ada.tech.cielo3.application.usecases;

import ada.tech.cielo3.application.dtos.InputDeleteCustomerDTO;
import ada.tech.cielo3.application.repositories.CustomerRepository;
import ada.tech.cielo3.domain.entities.Customer;
import ada.tech.cielo3.exceptions.NotFoundException;
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
