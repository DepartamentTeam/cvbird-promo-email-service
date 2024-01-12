package ai.cvbird.cvbirdpromoemailservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDTO {
    /**  message id **/
    Long id;

    /**  message topic **/
    String topic;

    /**  username **/
    String name;

    /**  user email **/
    String email;

    /**  message **/
    String message;

    @Override
    public String toString() {
        return "id: " +  id + " topic: " + topic + " name: " +
                name + " email: " + email + " message: " + message;
    }
}
