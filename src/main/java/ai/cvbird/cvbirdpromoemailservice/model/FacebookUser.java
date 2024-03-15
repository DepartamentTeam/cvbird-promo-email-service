package ai.cvbird.cvbirdpromoemailservice.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Simple JavaBean object that represent an email
 */
@Entity
@Table(name = "facebook_user", indexes = {
        @Index(name = "idx__facebook_user__email", columnList = "email"),
        @Index(name = "idx__facebook_user__id", columnList = "id")
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FacebookUser {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "email", nullable = false, updatable = false, unique = true)
    String email;

    @Column(name = "facebook_id", updatable = false)
    String facebookId;

    @Column(name = "facebook_name", updatable = false)
    String facebookName;

}