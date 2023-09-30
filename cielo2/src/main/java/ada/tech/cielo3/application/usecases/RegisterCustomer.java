package ada.tech.cielo3.application.usecases;

import ada.tech.cielo3.application.dtos.InputRegisterCustomerDTO;
import ada.tech.cielo3.application.dtos.OutputRegisterCustomerDTO;
import ada.tech.cielo3.application.repositories.CustomerRepository;
import ada.tech.cielo3.domain.entities.Customer;
import ada.tech.cielo3.domain.valueObjects.Cnpj;
import ada.tech.cielo3.domain.valueObjects.Company;
import ada.tech.cielo3.domain.valueObjects.Cpf;
import ada.tech.cielo3.domain.valueObjects.Email;
import ada.tech.cielo3.exceptions.BadRequestException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegisterCustomer {
    private final CustomerRepository customerRepository;

    public OutputRegisterCustomerDTO execute(InputRegisterCustomerDTO input) {
        Customer emailAlreadyUsed = customerRepository.findByEmail(input.email());
        if (emailAlreadyUsed != null) {
            throw new BadRequestException("Email already used");
        }

        Customer cpfAlreadyUsed = customerRepository.findByCpf(input.cpf());
        if (cpfAlreadyUsed != null) {
            throw new BadRequestException("CPF already used");
        }

        Cpf cpf = new Cpf(input.cpf());
        Email email = new Email(input.email());
        Customer customer = Customer.create(input.fullName(), cpf, email, new Company(
                input.companyCnpj() == null ? null : new Cnpj(input.companyCnpj()),
                input.companyName(),
                input.merchantCategoryCode()));

        customerRepository.save(customer);

        return new OutputRegisterCustomerDTO(customer.getUuid());
    }
}
