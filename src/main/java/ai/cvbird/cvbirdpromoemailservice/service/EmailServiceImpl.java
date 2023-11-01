package ai.cvbird.cvbirdpromoemailservice.service;

import ai.cvbird.cvbirdpromoemailservice.dao.EmailRepository;
import ai.cvbird.cvbirdpromoemailservice.dto.EmailConvertor;
import ai.cvbird.cvbirdpromoemailservice.dto.EmailDTO;
import ai.cvbird.cvbirdpromoemailservice.model.Email;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    private final EmailRepository emailRepository;
    private final EmailConvertor emailConvertor;

    @Autowired
    public EmailServiceImpl(EmailRepository emailRepository, EmailConvertor emailConvertor) {
        this.emailRepository = emailRepository;
        this.emailConvertor = emailConvertor;
    }

    @Override
    public Email save(EmailDTO emailDTO) {
        return emailRepository.save(emailConvertor.fromDTO(emailDTO));
    }


}
