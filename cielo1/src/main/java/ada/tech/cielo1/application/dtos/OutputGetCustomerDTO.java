package ada.tech.cielo1.application.dtos;

import java.util.UUID;

public record OutputGetCustomerDTO(UUID uuid, String fullName, String cpf, String email, String merchantCategoryCode, String companyCnpj, String companyName) {
}
