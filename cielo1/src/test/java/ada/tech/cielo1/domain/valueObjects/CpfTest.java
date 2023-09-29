package ada.tech.cielo1.domain.valueObjects;

import ada.tech.cielo1.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CpfTest {

    @Test
    public void testCpf() {
        Cpf cpf = new Cpf("12345678909");
        assertEquals("12345678909", cpf.getValue());
    }

    @Test
    public void testCpfInvalid() {
        assertThrows(BadRequestException.class, () -> {
            new Cpf("12345678900");
        });
        assertThrows(BadRequestException.class, () -> {
            new Cpf("1234567890000");
        });
        assertThrows(BadRequestException.class, () -> {
            new Cpf("00000000000");
        });
    }

}
