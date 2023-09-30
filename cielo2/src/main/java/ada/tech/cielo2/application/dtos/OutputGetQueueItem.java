package ada.tech.cielo2.application.dtos;

import java.util.UUID;

public record OutputGetQueueItem(UUID uuid, String fullName, String cpf, String email, String companyCnpj, String companyName, String merchantCategoryCode){
}
