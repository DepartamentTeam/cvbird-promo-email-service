package ai.cvbird.cvbirdpromoemailservice.validator;

import ai.cvbird.cvbirdpromoemailservice.dao.GoogleUserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueGoogleUserValidator implements ConstraintValidator<UniqueGoogleUser, String> {

    @Autowired
    GoogleUserRepository googleUserRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return googleUserRepository.findByGoogleEmail(email) == null;
    }
}