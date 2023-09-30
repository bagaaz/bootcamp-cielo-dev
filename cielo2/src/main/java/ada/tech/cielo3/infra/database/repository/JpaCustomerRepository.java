package ada.tech.cielo3.infra.database.repository;


import ada.tech.cielo3.application.repositories.CustomerRepository;
import ada.tech.cielo3.domain.entities.Customer;
import ada.tech.cielo3.domain.valueObjects.Cnpj;
import ada.tech.cielo3.domain.valueObjects.Company;
import ada.tech.cielo3.domain.valueObjects.Cpf;
import ada.tech.cielo3.domain.valueObjects.Email;
import ada.tech.cielo3.infra.database.models.CustomerModel;
import ada.tech.cielo3.infra.database.models.JpaCustomer;
import ada.tech.cielo3.infra.queue.ServiceQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class JpaCustomerRepository implements CustomerRepository {

    @Autowired
    private JpaCustomer repository;

    @Autowired
    private ServiceQueue serviceQueue;

    @Override
    public void save(Customer customer) {
        Company company = customer.getCompany();
        CustomerModel customerModel = new CustomerModel(
            customer.getUuid(),
            company.getCnpj() == null ? null : company.getCnpj().getValue(),
            company.getCompanyName(),
            company.getMerchantCategoryCode(),
            customer.getCpf().getValue(),
            customer.getFullName(),
            customer.getEmail().getValue()
        );

        serviceQueue.enqueue(customer);

        repository.save(customerModel);
    }

    @Override
    public Customer findById(UUID uuid) {
        CustomerModel customerModel = repository.findByUuid(uuid);
        if (customerModel == null) return null;

        return new Customer(
            customerModel.getUuid(),
            customerModel.getFullName(),
            new Cpf(customerModel.getCpf()),
            new Email(customerModel.getEmail()),
            new Company(
                customerModel.getCompanyCnpj() == null ? null : new Cnpj(customerModel.getCompanyCnpj()),
                customerModel.getCompanyName(),
                customerModel.getMerchantCategoryCode()
            )
        );
    }

    @Override
    public Customer findByEmail(String email) {
        CustomerModel customerModel = repository.findByEmail(email);
        if (customerModel == null) return null;

        return new Customer(
            customerModel.getUuid(),
            customerModel.getFullName(),
            new Cpf(customerModel.getCpf()),
            new Email(customerModel.getEmail()),
            new Company(
                customerModel.getCompanyCnpj() == null ? null : new Cnpj(customerModel.getCompanyCnpj()),
                customerModel.getCompanyName(),
                customerModel.getMerchantCategoryCode()
            )
        );
    }

    @Override
    public Customer findByCpf(String cpf) {
        CustomerModel customerModel = repository.findByCpf(cpf);
        if (customerModel == null) return null;

        return new Customer(
            customerModel.getUuid(),
            customerModel.getFullName(),
            new Cpf(customerModel.getCpf()),
            new Email(customerModel.getEmail()),
            new Company(
                customerModel.getCompanyCnpj() == null ? null : new Cnpj(customerModel.getCompanyCnpj()),
                customerModel.getCompanyName(),
                customerModel.getMerchantCategoryCode()
            )
        );
    }

    @Override
    public void update(Customer customer) {
        CustomerModel customerModel = repository.findByUuid(customer.getUuid());
        Company company = customer.getCompany();
        customerModel.setFullName(customer.getFullName());
        customerModel.setCpf(customer.getCpf().getValue());
        customerModel.setEmail(customer.getEmail().getValue());
        customerModel.setCompanyCnpj(company.getCnpj() == null ? null : company.getCnpj().getValue());
        customerModel.setCompanyName(company.getCompanyName());
        customerModel.setMerchantCategoryCode(company.getMerchantCategoryCode());

        serviceQueue.enqueue(customer);

        repository.save(customerModel);
    }

    @Override
    public void delete(UUID uuid) {
        CustomerModel customerModel = repository.findByUuid(uuid);
        repository.delete(customerModel);
    }
}
