package ada.tech.cielo3.application.dtos;

import java.util.UUID;

public record InputUpdateCustomerDTO(UUID uuid, String fullName, String cpf, String email, String merchantCategoryCode, String companyCnpj, String companyName) {
}
