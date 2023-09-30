package ada.tech.cielo3.application.dtos;

import ada.tech.cielo3.exceptions.BadRequestException;

public record InputRegisterCustomerDTO(String fullName, String cpf, String email, String merchantCategoryCode, String companyCnpj, String companyName) {
    public InputRegisterCustomerDTO {
        if (fullName == null || fullName.isEmpty()) throw new BadRequestException("Invalid fullName");
        if (cpf == null || cpf.isEmpty()) throw new BadRequestException("Invalid cpf");
        if (email == null || email.isEmpty()) throw new BadRequestException("Invalid email");
        if (merchantCategoryCode == null || merchantCategoryCode.isEmpty()) throw new BadRequestException("Invalid merchantCategoryCode");
    }
}
