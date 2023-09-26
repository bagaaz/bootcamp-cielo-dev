package ada.tech.cielo1.client;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "clients")
@Entity(name = "clients")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false, nullable = false, unique = true)
    private UUID uuid;
    @Column(length = 7, nullable = false)
    private ClientType type;
    @Column(length = 4, nullable = false)
    private String ccm;
    @Column(length = 100, nullable = false)
    private String email;

    public Client(ClientRequestDTO data) {
        this.type = data.type();
        this.ccm = data.ccm();
        this.email = data.email();
    }

    @PrePersist
    public void generateUUID() {
        if (uuid == null) {
            uuid = UUID.randomUUID();
        }
    }

}
