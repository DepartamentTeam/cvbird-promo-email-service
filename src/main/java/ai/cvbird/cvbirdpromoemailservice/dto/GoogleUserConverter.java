package ai.cvbird.cvbirdpromoemailservice.dto;

import ai.cvbird.cvbirdpromoemailservice.model.GoogleUser;
import org.springframework.stereotype.Component;

@Component
public class GoogleUserConverter {
    public GoogleUser fromDTO(GoogleUserDTO googleUserDTO) {
        GoogleUser googleUser = new GoogleUser();
        googleUser.setId(googleUserDTO.getId());
        googleUser.setGoogleEmail(googleUserDTO.getGoogleEmail().toLowerCase());
        googleUser.setGoogleName(googleUserDTO.getGoogleName());
        googleUser.setGoogleUserAttributes(googleUserDTO.getGoogleUserAttributes());
        return googleUser;
    }

    public GoogleUserDTO toDTO(GoogleUser googleUser) {
        GoogleUserDTO googleUserDTO = new GoogleUserDTO();
        googleUserDTO.setId(googleUser.getId());
        googleUserDTO.setGoogleEmail(googleUser.getGoogleEmail());
        googleUserDTO.setGoogleName(googleUser.getGoogleName());
        googleUserDTO.setGoogleUserAttributes(googleUser.getGoogleUserAttributes());
        return googleUserDTO;
    }
}
