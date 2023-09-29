package ada.tech.desafio.domain.customer;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "customers")
@Table(name = "customers")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private UUID uuid;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 11, nullable = false, unique = true)
    private String cpf;
    @Column(length = 100, nullable = false)
    private String email;
    @Column(length = 4, nullable = false)
    private String merchantCategoryCode;
}
