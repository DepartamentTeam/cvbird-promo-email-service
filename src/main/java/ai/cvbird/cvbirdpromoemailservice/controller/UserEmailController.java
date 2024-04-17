package ai.cvbird.cvbirdpromoemailservice.controller;

import ai.cvbird.cvbirdpromoemailservice.dto.FacebookUserDTO;
import ai.cvbird.cvbirdpromoemailservice.dto.UserEmailDTO;
import ai.cvbird.cvbirdpromoemailservice.entity.SimpleResponseEntity;
import ai.cvbird.cvbirdpromoemailservice.model.FacebookUser;
import ai.cvbird.cvbirdpromoemailservice.model.UserEmail;
import ai.cvbird.cvbirdpromoemailservice.service.UserEmailStoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/promo/email")
@CrossOrigin
public class UserEmailController {

    @Autowired
    UserEmailStoreService userEmailStoreService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponseEntity> saveEmail(@RequestBody @Valid UserEmailDTO userEmailDTO){
        UserEmail userEmail = userEmailStoreService.saveEmail(userEmailDTO);
        if (userEmail != null) {
            SimpleResponseEntity simpleResponseEntity = new SimpleResponseEntity("The user has been successfully registered");
            return new ResponseEntity<>(simpleResponseEntity, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.ALREADY_REPORTED);
        }
    }

    @PostMapping(value = "/facebook", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SimpleResponseEntity> saveFacebookUser(@RequestBody @Valid FacebookUserDTO facebookUserDTO){
        FacebookUser facebookUser = userEmailStoreService.saveFacebookUser(facebookUserDTO);
        if (facebookUser != null) {
            SimpleResponseEntity simpleResponseEntity = new SimpleResponseEntity("The user has been successfully registered");
            return new ResponseEntity<>(simpleResponseEntity, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.ALREADY_REPORTED);
        }
    }

    @GetMapping(value = "/get_google_user")
    public ResponseEntity<SimpleResponseEntity> getGoogleUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SimpleResponseEntity simpleResponseEntity = new SimpleResponseEntity(null);
        if (authentication.getPrincipal() instanceof DefaultOAuth2User) {
            simpleResponseEntity = new SimpleResponseEntity(((DefaultOAuth2User) authentication.getPrincipal()).getAttribute("name"));
        }
        return new ResponseEntity<>(simpleResponseEntity, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
