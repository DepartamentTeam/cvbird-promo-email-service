package ai.cvbird.cvbirdpromoemailservice.dto;

import ai.cvbird.cvbirdpromoemailservice.validator.UniqueGoogleUser;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GoogleUserDTO {

    Long id;

    // TODO  strengthen the restrictions
    // https://haacked.com/archive/2007/08/21/i-knew-how-to-validate-an-email-address-until-i.aspx/
    //  @Email(message="Please provide a valid email address",
    //  regexp = "^(?!\.)("([^"\r\\]|\\["\r\\])*"|([-a-z0-9!#$%&'*+/=?^_`{|}~]|(?<!\.)\.)*)(?<!\.)@[a-z0-9][\w\.-]*[a-z0-9]\.[a-z][a-z\.]*[a-z]$")
    // @Email(message="Please provide a valid email address", regexp = ".+[@].+[\\.].+")
    @UniqueGoogleUser
    @NotNull(message = "email must be not NULL")
    String googleEmail;

    String googleName;
    String googleUserAttributes;
}
