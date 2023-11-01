package ai.cvbird.cvbirdpromoemailservice.service;

import ai.cvbird.cvbirdpromoemailservice.dto.EmailDTO;
import ai.cvbird.cvbirdpromoemailservice.model.Email;

public interface EmailService {
    public Email save(EmailDTO emailDTO);
}
