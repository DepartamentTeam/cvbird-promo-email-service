package ai.cvbird.cvbirdpromoemailservice.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Simple JavaBean object that represent a feedback
 */
@Entity
@Table(name = "promo_feedback")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Feedback {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "topic")
    String topic;

    @Column(name = "name")
    String name;

    @Column(name = "email")
    String email;

    @Column(name = "message")
    String message;
}
