package ada.tech.cielo1.domain.valueObjects;

import ada.tech.cielo1.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CnpjTest {

    @Test
    public void testCnpj() {
        Cnpj cnpj = new Cnpj("66787211000124");
        assertEquals("66787211000124", cnpj.getValue());
    }

    @Test
    public void testCnpjInvalid() {
        assertThrows(BadRequestException.class, () -> {
            new Cnpj("66787211000125");
        });
        assertThrows(BadRequestException.class, () -> {
            new Cnpj("66787211000124487");
        });
    }
}
