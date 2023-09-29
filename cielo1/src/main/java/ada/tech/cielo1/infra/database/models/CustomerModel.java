package ada.tech.cielo1.infra.database.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false, nullable = false, unique = true)
    private UUID uuid;
    @Column(length = 14, nullable = true)
    private String companyCnpj;
    @Column(length = 50, nullable = true)
    private String companyName;
    @Column(length = 4, nullable = false)
    private String merchantCategoryCode;
    @Column(length = 11, nullable = false)
    private String cpf;
    @Column(length = 50, nullable = false)
    private String fullName;
    @Column(length = 100, nullable = false)
    private String email;

    public CustomerModel(UUID uuid, String companyCnpj, String companyName, String merchantCategoryCode, String cpf, String fullName, String email) {
        this.uuid = uuid;
        this.companyCnpj = companyCnpj;
        this.companyName = companyName;
        this.merchantCategoryCode = merchantCategoryCode;
        this.cpf = cpf;
        this.fullName = fullName;
        this.email = email;
    }

}
