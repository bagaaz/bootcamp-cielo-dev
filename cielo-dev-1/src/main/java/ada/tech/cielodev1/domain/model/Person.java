package ada.tech.cielodev1.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Person {
    @Id
    @Column(length = 11, nullable = false)
    private String cpf;
    @Column(length = 50, nullable = false)
    private String name;
}
