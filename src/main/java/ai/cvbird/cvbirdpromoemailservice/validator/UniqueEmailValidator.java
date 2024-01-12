package ai.cvbird.cvbirdpromoemailservice.validator;

import ai.cvbird.cvbirdpromoemailservice.dao.UserEmailRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    UserEmailRepository userEmailRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return userEmailRepository.findByEmail(email) == null;
    }
}