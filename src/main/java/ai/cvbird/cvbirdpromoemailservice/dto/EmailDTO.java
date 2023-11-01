package ai.cvbird.cvbirdpromoemailservice.dto;

import ai.cvbird.cvbirdpromoemailservice.validator.UniqueEmail;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {

    Long id;

    @Email(message="Please provide a valid email address", regexp = ".+[@].+[\\.].+")
    @UniqueEmail
    String email;
}
