package ada.tech.cielo3.domain.entities;

import ada.tech.cielo3.domain.valueObjects.Company;
import ada.tech.cielo3.domain.valueObjects.Cpf;
import ada.tech.cielo3.domain.valueObjects.Email;
import ada.tech.cielo3.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testCustomer() {
        Customer customer = Customer.create(
                "Gabriel Oliveira",
                new Cpf("12345678909"),
                new Email("teste@gmail.com"),
                new Company(null, null, "1234")
        );

        assertEquals("Gabriel Oliveira", customer.getFullName());
        assertEquals("12345678909", customer.getCpf().getValue());
        assertEquals("teste@gmail.com", customer.getEmail().getValue());
        assertEquals("1234", customer.getCompany().getMerchantCategoryCode());
        assertNotNull(customer.getUuid());
    }

    @Test
    public void testCustomerChangeName() {
        Customer customer = Customer.create(
                "Gabriel Oliveira",
                new Cpf("12345678909"),
                new Email("teste@gmail.com"),
                new Company(null, null, "1234")
        );

        customer.changeName("Gabriel Oliveira Silva");
        assertEquals("Gabriel Oliveira Silva", customer.getFullName());
        assertThrows(BadRequestException.class, () -> {
            customer.changeName("Gabriel Oliveira Silva");
        });
    }

    @Test
    public void testCustomerChangeCpf() {
        Customer customer = Customer.create(
                "Gabriel Oliveira",
                new Cpf("12345678909"),
                new Email("test@gmail.com"),
                new Company(null, null, "1234")
        );

        customer.changeCpf(new Cpf("00000000191"));
        assertEquals("00000000191", customer.getCpf().getValue());
        assertThrows(BadRequestException.class, () -> {
            customer.changeCpf(new Cpf("00000000191"));
        });
    }

    @Test
    public void testCustomerChangeEmail() {
        Customer customer = Customer.create(
                "Gabriel Oliveira",
                new Cpf("12345678909"),
                new Email("test@gmail.com"),
                new Company(null, null, "1234")
        );

        customer.changeEmail(new Email("contato@gmail.com"));
        assertEquals("contato@gmail.com", customer.getEmail().getValue());
        assertThrows(BadRequestException.class, () -> {
            customer.changeEmail(new Email("contato@gmail.com"));
        });
    }

    @Test
    public void testCustomerFullNameInvalid() {
        assertThrows(BadRequestException.class, () -> {
            Customer.create(
                    "Gabriel Oliveira Gabriel Oliveira Gabriel Oliveira Gabriel Oliveira Gabriel Oliveira",
                    new Cpf("12345678909"),
                    new Email("teste@gmail.com"),
                    new Company(null, null, "1234")
            );
        });
    }

}
