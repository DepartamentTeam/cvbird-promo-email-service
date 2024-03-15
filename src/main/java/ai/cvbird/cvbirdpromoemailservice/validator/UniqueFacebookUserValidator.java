package ai.cvbird.cvbirdpromoemailservice.validator;

import ai.cvbird.cvbirdpromoemailservice.dao.FacebookUserRepository;
import ai.cvbird.cvbirdpromoemailservice.dao.UserEmailRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueFacebookUserValidator implements ConstraintValidator<UniqueFacebookUser, String> {

    @Autowired
    FacebookUserRepository facebookUserRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return facebookUserRepository.findByEmail(email) == null;
    }
}
