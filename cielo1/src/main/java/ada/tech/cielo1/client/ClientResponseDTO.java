package ada.tech.cielo1.client;

import java.util.UUID;

public record ClientResponseDTO(UUID uuid, ClientType type, String ccm, String email) {

    public ClientResponseDTO(Client client) {
        this(client.getUuid(), client.getType(), client.getCcm(), client.getEmail());
    }

}
