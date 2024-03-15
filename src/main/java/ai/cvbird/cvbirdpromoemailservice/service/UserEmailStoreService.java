package ai.cvbird.cvbirdpromoemailservice.service;

import ai.cvbird.cvbirdpromoemailservice.dto.FacebookUserDTO;
import ai.cvbird.cvbirdpromoemailservice.dto.UserEmailDTO;
import ai.cvbird.cvbirdpromoemailservice.model.FacebookUser;
import ai.cvbird.cvbirdpromoemailservice.model.UserEmail;

public interface UserEmailStoreService {
    UserEmail saveEmail(UserEmailDTO userEmailDTO);

    FacebookUser saveFacebookUser(FacebookUserDTO facebookUserDTO);
}
