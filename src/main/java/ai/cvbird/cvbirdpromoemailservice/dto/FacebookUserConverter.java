package ai.cvbird.cvbirdpromoemailservice.dto;

import ai.cvbird.cvbirdpromoemailservice.model.FacebookUser;
import org.springframework.stereotype.Component;

@Component
public class FacebookUserConverter {
    public FacebookUser fromDTO(FacebookUserDTO facebookUserDTO) {
        FacebookUser facebookUser = new FacebookUser();
        facebookUser.setId(facebookUserDTO.getId());
        facebookUser.setEmail(facebookUserDTO.getEmail().toLowerCase());
        facebookUser.setFacebookId(facebookUserDTO.getFacebookId());
        facebookUser.setFacebookName(facebookUserDTO.getFacebookName());
        return facebookUser;
    }

    public FacebookUserDTO toDTO(FacebookUser facebookUser) {
        FacebookUserDTO facebookUserDTO = new FacebookUserDTO();
        facebookUserDTO.setId(facebookUser.getId());
        facebookUserDTO.setEmail(facebookUser.getEmail());
        facebookUserDTO.setFacebookId(facebookUser.getFacebookId());
        facebookUserDTO.setFacebookName(facebookUser.getFacebookName());
        return facebookUserDTO;
    }
}
