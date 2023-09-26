package ada.tech.cielodev1.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Company {

    @Id
    @Column(length = 14, nullable = false)
    private String cnpj;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 11, nullable = false)
    private String contactCpf;
    @Column(length = 50, nullable = false)
    private String contactName;
}
