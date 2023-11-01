package ai.cvbird.cvbirdpromoemailservice.validator;

import ai.cvbird.cvbirdpromoemailservice.dao.EmailRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    EmailRepository emailRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return emailRepository.findByEmail(email) == null;
    }
}