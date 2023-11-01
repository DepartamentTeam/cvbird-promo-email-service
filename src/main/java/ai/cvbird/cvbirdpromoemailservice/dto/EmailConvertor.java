package ai.cvbird.cvbirdpromoemailservice.dto;

import ai.cvbird.cvbirdpromoemailservice.model.Email;
import org.springframework.stereotype.Component;

@Component
public class EmailConvertor {
    public Email fromDTO(EmailDTO emailDTO) {
        Email email = new Email();
        email.setId(emailDTO.getId());
        email.setEmail(emailDTO.getEmail().toLowerCase());
        return email;
    }

    public EmailDTO toDTO(Email email) {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setId(email.getId());
        emailDTO.setEmail(email.getEmail());
        return emailDTO;
    }
}
