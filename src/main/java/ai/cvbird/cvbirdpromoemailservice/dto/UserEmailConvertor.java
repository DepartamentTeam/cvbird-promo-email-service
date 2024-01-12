package ai.cvbird.cvbirdpromoemailservice.dto;

import ai.cvbird.cvbirdpromoemailservice.model.UserEmail;
import org.springframework.stereotype.Component;

@Component
public class UserEmailConvertor {
    public UserEmail fromDTO(UserEmailDTO userEmailDTO) {
        UserEmail userEmail = new UserEmail();
        userEmail.setId(userEmailDTO.getId());
        userEmail.setEmail(userEmailDTO.getEmail().toLowerCase());
        return userEmail;
    }

    public UserEmailDTO toDTO(UserEmail userEmail) {
        UserEmailDTO userEmailDTO = new UserEmailDTO();
        userEmailDTO.setId(userEmail.getId());
        userEmailDTO.setEmail(userEmail.getEmail());
        return userEmailDTO;
    }
}
