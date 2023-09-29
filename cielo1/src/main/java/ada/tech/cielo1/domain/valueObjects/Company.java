package ada.tech.cielo1.domain.valueObjects;

import ada.tech.cielo1.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Company {
    private Cnpj cnpj;
    private String companyName;
    private String merchantCategoryCode;

    public Company(Cnpj cnpj, String companyName, String merchantCategoryCode) {
        if (cnpj != null && companyName == null) throw new BadRequestException("Company name is required");
        if (cnpj == null && companyName != null) throw new BadRequestException("CNPJ is required");
        verifyMerchantCategoryCodeSize(merchantCategoryCode);
        verifyCompanyNameSize(companyName);
        this.cnpj = cnpj;
        this.companyName = companyName;
        this.merchantCategoryCode = merchantCategoryCode;
    }

    public void changeCompanyName(String companyName) {
        verifyCompanyNameSize(companyName);
        if (this.companyName.equals(companyName)) {
            throw new BadRequestException("Company name is the same as the current one");
        }
        this.companyName = companyName;
    }

    public void changeMerchantCategoryCode(String merchantCategoryCode) {
        verifyMerchantCategoryCodeSize(merchantCategoryCode);
        if (this.merchantCategoryCode.equals(merchantCategoryCode)) {
            throw new BadRequestException("Merchant category code is the same as the current one");
        }
        this.merchantCategoryCode = merchantCategoryCode;
    }

    public void changeCnpj(Cnpj cnpj) {
        if (this.cnpj.equals(cnpj)) {
            throw new BadRequestException("CNPJ is the same as the current one");
        }
        this.cnpj = cnpj;
    }

    private void verifyMerchantCategoryCodeSize(String value) {
        if (value.length() > 4) {
            throw new BadRequestException("Merchant category code must be less than 4 characters");
        }
    }

    private void verifyCompanyNameSize(String value) {
        if (value != null && value.length() > 50) {
            throw new BadRequestException("Company name must be less than 50 characters");
        }
    }
}
