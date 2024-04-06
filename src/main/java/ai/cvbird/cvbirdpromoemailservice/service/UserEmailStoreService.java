package ai.cvbird.cvbirdpromoemailservice.service;

import ai.cvbird.cvbirdpromoemailservice.dto.FacebookUserDTO;
import ai.cvbird.cvbirdpromoemailservice.dto.GoogleUserDTO;
import ai.cvbird.cvbirdpromoemailservice.dto.UserEmailDTO;
import ai.cvbird.cvbirdpromoemailservice.model.FacebookUser;
import ai.cvbird.cvbirdpromoemailservice.model.GoogleUser;
import ai.cvbird.cvbirdpromoemailservice.model.UserEmail;

public interface UserEmailStoreService {
    UserEmail saveEmail(UserEmailDTO userEmailDTO);

    FacebookUser saveFacebookUser(FacebookUserDTO facebookUserDTO);

    GoogleUser saveGoogleUser(GoogleUserDTO googleUserDTO);
}
