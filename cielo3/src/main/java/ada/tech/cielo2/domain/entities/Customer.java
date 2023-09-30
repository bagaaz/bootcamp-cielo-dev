package ada.tech.cielo2.domain.entities;

import ada.tech.cielo2.domain.valueObjects.*;
import ada.tech.cielo2.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Customer {
    private UUID uuid;
    private String fullName;
    private Cpf cpf;
    private Email email;
    private Company company;

    public static Customer create(String fullName, Cpf cpf, Email email, Company company) {
        Customer customer = new Customer(UUID.randomUUID(), fullName, cpf, email, company);
        customer.verifyFullNameSize(fullName);
        return customer;
    }

    public void changeName(String fullName) {
        verifyFullNameSize(fullName);
        if (this.fullName.equals(fullName)) {
            throw new BadRequestException("The new name is the same as the current name");
        }
        this.fullName = fullName;
    }

    public void changeCpf(Cpf cpf) {
        if (this.cpf.getValue().equals(cpf.getValue())) {
            throw new BadRequestException("The new cpf is the same as the current cpf");
        }
        this.cpf = cpf;
    }

    public void changeEmail(Email email) {
        if (this.email.getValue().equals(email.getValue())) {
            throw new BadRequestException("The new email is the same as the current email");
        }
        this.email = email;
    }

    private void verifyFullNameSize(String value) {
        if (value.length() > 50) {
            throw new BadRequestException("Full name must be less than 50 characters");
        }
    }
}
