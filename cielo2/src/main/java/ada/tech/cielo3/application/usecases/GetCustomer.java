package ada.tech.cielo3.application.usecases;

import ada.tech.cielo3.application.dtos.InputGetCustomerDTO;
import ada.tech.cielo3.application.dtos.OutputGetCustomerDTO;
import ada.tech.cielo3.application.repositories.CustomerRepository;
import ada.tech.cielo3.domain.entities.Customer;
import ada.tech.cielo3.exceptions.NotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetCustomer {

    private final CustomerRepository customerRepository;

    public OutputGetCustomerDTO execute(InputGetCustomerDTO input) {
        Customer customer = customerRepository.findById(input.uuid());
        if (customer == null) throw new NotFoundException("Customer");

        return new OutputGetCustomerDTO(
            customer.getUuid(),
            customer.getFullName(),
            customer.getCpf().getValue(),
            customer.getEmail().getValue(),
            customer.getCompany().getMerchantCategoryCode(),
            customer.getCompany().getCnpj() == null ? null : customer.getCompany().getCnpj().getValue(),
            customer.getCompany().getCompanyName()
        );
    }
}
