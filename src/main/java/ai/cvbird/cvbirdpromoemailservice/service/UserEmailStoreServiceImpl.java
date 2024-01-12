package ai.cvbird.cvbirdpromoemailservice.service;

import ai.cvbird.cvbirdpromoemailservice.dao.UserEmailRepository;
import ai.cvbird.cvbirdpromoemailservice.dto.UserEmailConvertor;
import ai.cvbird.cvbirdpromoemailservice.dto.UserEmailDTO;
import ai.cvbird.cvbirdpromoemailservice.model.UserEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEmailStoreServiceImpl implements UserEmailStoreService {

    private final UserEmailRepository userEmailRepository;
    private final UserEmailConvertor userEmailConvertor;

    @Autowired
    public UserEmailStoreServiceImpl(UserEmailRepository userEmailRepository, UserEmailConvertor userEmailConvertor) {
        this.userEmailRepository = userEmailRepository;
        this.userEmailConvertor = userEmailConvertor;
    }

    @Override
    public UserEmail save(UserEmailDTO userEmailDTO) {
        return userEmailRepository.save(userEmailConvertor.fromDTO(userEmailDTO));
    }


}
