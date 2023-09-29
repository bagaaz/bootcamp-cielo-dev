package ada.tech.cielo1.application.usecases;

import ada.tech.cielo1.application.dtos.InputUpdateCustomerDTO;
import ada.tech.cielo1.application.repositories.CustomerRepository;
import ada.tech.cielo1.domain.entities.Customer;
import ada.tech.cielo1.domain.valueObjects.Cnpj;
import ada.tech.cielo1.domain.valueObjects.Company;
import ada.tech.cielo1.domain.valueObjects.Cpf;
import ada.tech.cielo1.domain.valueObjects.Email;
import ada.tech.cielo1.exceptions.NotFoundException;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class UpdateCustomer {

    private final CustomerRepository repository;

    public void execute(InputUpdateCustomerDTO input) {
        Customer customer = repository.findById(input.uuid());
        if (customer == null) throw new NotFoundException("Customer");

        if (input.fullName() != null) {
            customer.changeName(input.fullName());
        }

        if (input.cpf() != null) {
            customer.changeCpf(new Cpf(input.cpf()));
        }

        if (input.email() != null) {
            customer.changeEmail(new Email(input.email()));
        }

        Company company = customer.getCompany();


        if (input.merchantCategoryCode() != null) {
            company.changeMerchantCategoryCode(input.merchantCategoryCode());
        }

        if (input.companyCnpj() != null) {
            company.changeCnpj(new Cnpj(input.companyCnpj()));
        }

        if (input.companyName() != null) {
            company.changeCompanyName(input.companyName());
        }

        repository.update(customer);
    }
}
