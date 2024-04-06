package ai.cvbird.cvbirdpromoemailservice.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Simple JavaBean object that represent an email
 */
@Entity
@Table(name = "google_user", indexes = {
        @Index(name = "idx__google_user__email", columnList = "google_email"),
        @Index(name = "idx__google_user__id", columnList = "id")
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GoogleUser {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "google_email", nullable = false, updatable = false, unique = true)
    String googleEmail;

    @Column(name = "google_name", updatable = false)
    String googleName;

    @Column(name = "google_user_attributes", updatable = false)
    String googleUserAttributes;

}