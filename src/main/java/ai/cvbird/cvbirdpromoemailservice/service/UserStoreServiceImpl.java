package ai.cvbird.cvbirdpromoemailservice.service;

import ai.cvbird.cvbirdpromoemailservice.dao.FacebookUserRepository;
import ai.cvbird.cvbirdpromoemailservice.dao.GoogleUserRepository;
import ai.cvbird.cvbirdpromoemailservice.dao.UserEmailRepository;
import ai.cvbird.cvbirdpromoemailservice.dto.*;
import ai.cvbird.cvbirdpromoemailservice.model.FacebookUser;
import ai.cvbird.cvbirdpromoemailservice.model.GoogleUser;
import ai.cvbird.cvbirdpromoemailservice.model.UserEmail;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStoreServiceImpl implements UserEmailStoreService {

    private final UserEmailRepository userEmailRepository;
    private final UserEmailConvertor userEmailConvertor;
    private final FacebookUserRepository facebookUserRepository;
    private final FacebookUserConverter facebookUserConverter;
    private final GoogleUserRepository googleUserRepository;
    private final  GoogleUserConverter googleUserConverter;

    @Autowired
    public UserStoreServiceImpl(UserEmailRepository userEmailRepository, UserEmailConvertor userEmailConvertor,
                                FacebookUserRepository facebookUserRepository, FacebookUserConverter facebookUserConverter,
                                GoogleUserRepository googleUserRepository, GoogleUserConverter googleUserConverter) {
        this.userEmailRepository = userEmailRepository;
        this.userEmailConvertor = userEmailConvertor;
        this.facebookUserRepository = facebookUserRepository;
        this.facebookUserConverter = facebookUserConverter;
        this.googleUserRepository = googleUserRepository;
        this.googleUserConverter = googleUserConverter;

    }

    @Override
    public UserEmail saveEmail(UserEmailDTO userEmailDTO) {
        return userEmailRepository.save(userEmailConvertor.fromDTO(userEmailDTO));
    }

    @Override
    public FacebookUser saveFacebookUser(FacebookUserDTO facebookUserDTO) {
        return facebookUserRepository.save(facebookUserConverter.fromDTO(facebookUserDTO));
    }

    @Override
    public GoogleUser saveGoogleUser(GoogleUserDTO googleUserDTO) {
        if (googleUserRepository.findByGoogleEmail(googleUserDTO.getGoogleEmail()) == null) {
            return googleUserRepository.save(googleUserConverter.fromDTO(googleUserDTO));
        } else {
            return null;
        }
    }
}
