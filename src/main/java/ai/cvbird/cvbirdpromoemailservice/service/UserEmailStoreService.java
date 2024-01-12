package ai.cvbird.cvbirdpromoemailservice.service;

import ai.cvbird.cvbirdpromoemailservice.dto.UserEmailDTO;
import ai.cvbird.cvbirdpromoemailservice.model.UserEmail;

public interface UserEmailStoreService {
    UserEmail save(UserEmailDTO userEmailDTO);
}
