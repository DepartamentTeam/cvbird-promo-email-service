package ai.cvbird.cvbirdpromoemailservice.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueGoogleUserValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueGoogleUser {
    String message() default "Email address is already registered";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
