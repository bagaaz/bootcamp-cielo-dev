package ada.tech.cielo1.domain.valueObjects;

import ada.tech.cielo1.exceptions.BadRequestException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyTest {

    @Test
    public void testCompany() {
        Company company = new Company(new Cnpj("89159205000128"), "Oldbyte Store", "1234");
        assertEquals("89159205000128", company.getCnpj().getValue());
        assertEquals("Oldbyte Store", company.getCompanyName());
        assertEquals("1234", company.getMerchantCategoryCode());
    }

    @Test
    public void testCompanyOnlyMcc() {
        Company company = new Company(null, null, "1234");
        assertNull(company.getCnpj());
        assertNull(company.getCompanyName());
        assertEquals("1234", company.getMerchantCategoryCode());
    }

    @Test
    public void testCompanyWithoutCnpj() {
        assertThrows(BadRequestException.class, () -> {
            new Company(null, "Oldbyte Store", "1234");
        });
    }

    @Test
    public void testCompanyWithoutCompanyName() {
        assertThrows(BadRequestException.class, () -> {
            new Company(new Cnpj("28067719000169"), null, "1234");
        });
    }

    @Test
    public void testCompanyWithoutMcc() {
        assertThrows(BadRequestException.class, () -> {
            new Company(new Cnpj("28067719000169"), "Oldbyte Store", null);
        });
    }

    @Test
    public void testChangeCompanyName() {
        Company company = new Company(new Cnpj("28067719000169"), "Oldbyte Store", "1234");
        company.changeCompanyName("Newbyte Store");
        assertEquals("Newbyte Store", company.getCompanyName());
        assertThrows(BadRequestException.class, () -> {
            company.changeCompanyName("Newbyte Store");
        });
    }

    @Test
    public void testChangeCompanyCnpj() {
        Company company = new Company(new Cnpj("28067719000169"), "Oldbyte Store", "1234");
        company.changeCnpj(new Cnpj("91527806000198"));
        assertEquals("91527806000198", company.getCnpj().getValue());
        assertThrows(BadRequestException.class, () -> {
            company.changeCnpj(new Cnpj("91527806000198"));
        });
    }

    @Test
    public void testChangeMerchantCategoryCode() {
        Company company = new Company(new Cnpj("28067719000169"), "Oldbyte Store", "1234");
        company.changeMerchantCategoryCode("4321");
        assertEquals("4321", company.getMerchantCategoryCode());
        assertThrows(BadRequestException.class, () -> {
            company.changeMerchantCategoryCode("4321");
        });
    }

    @Test
    public void testCompanyNameInvalid() {
        assertThrows(BadRequestException.class, () -> {
            new Company(new Cnpj("28067719000169"), "Oldbyte Store 123456789123456789123456789123456789123", "1234");
        });
    }

    @Test
    public void testMerchantCategoryCodeInvalid() {
        assertThrows(BadRequestException.class, () -> {
            new Company(new Cnpj("28067719000169"), "Oldbyte Store", "12345");
        });
    }
}
