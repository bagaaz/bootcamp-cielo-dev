package ada.tech.cielo1.domain.valueObjects;

import ada.tech.cielo1.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    public void testEmail() {
        Email email = new Email("teste@gmail.com");
        assertEquals("teste@gmail.com", email.getValue());
    }

    @Test
    public void testEmailInvalid() {
        assertThrows(BadRequestException.class, () -> {
            new Email("teste");
        });
    }
}
