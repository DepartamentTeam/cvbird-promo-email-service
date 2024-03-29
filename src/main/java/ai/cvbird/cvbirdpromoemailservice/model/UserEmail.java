package ai.cvbird.cvbirdpromoemailservice.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Simple JavaBean object that represent an email
 */
@Entity
@Table(name = "promo_email", indexes = {
        @Index(name = "idx__promo_email_email", columnList = "email"),
        @Index(name = "idx__promo_email__id", columnList = "id")
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEmail {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "email", nullable = false, updatable = false, unique = true)
    String email;

}
