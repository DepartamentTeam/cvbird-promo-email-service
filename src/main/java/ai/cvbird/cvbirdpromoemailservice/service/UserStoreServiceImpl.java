package ai.cvbird.cvbirdpromoemailservice.service;

import ai.cvbird.cvbirdpromoemailservice.dao.FacebookUserRepository;
import ai.cvbird.cvbirdpromoemailservice.dao.UserEmailRepository;
import ai.cvbird.cvbirdpromoemailservice.dto.FacebookUserConverter;
import ai.cvbird.cvbirdpromoemailservice.dto.FacebookUserDTO;
import ai.cvbird.cvbirdpromoemailservice.dto.UserEmailConvertor;
import ai.cvbird.cvbirdpromoemailservice.dto.UserEmailDTO;
import ai.cvbird.cvbirdpromoemailservice.model.FacebookUser;
import ai.cvbird.cvbirdpromoemailservice.model.UserEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStoreServiceImpl implements UserEmailStoreService {

    private final UserEmailRepository userEmailRepository;
    private final UserEmailConvertor userEmailConvertor;
    private final FacebookUserRepository facebookUserRepository;
    private final FacebookUserConverter facebookUserConverter;

    @Autowired
    public UserStoreServiceImpl(UserEmailRepository userEmailRepository, UserEmailConvertor userEmailConvertor,
                                FacebookUserRepository facebookUserRepository, FacebookUserConverter facebookUserConverter) {
        this.userEmailRepository = userEmailRepository;
        this.userEmailConvertor = userEmailConvertor;
        this.facebookUserRepository = facebookUserRepository;
        this.facebookUserConverter = facebookUserConverter;

    }

    @Override
    public UserEmail saveEmail(UserEmailDTO userEmailDTO) {
        return userEmailRepository.save(userEmailConvertor.fromDTO(userEmailDTO));
    }

    @Override
    public FacebookUser saveFacebookUser(FacebookUserDTO facebookUserDTO) {
        return facebookUserRepository.save(facebookUserConverter.fromDTO(facebookUserDTO));
    }


}
