package ai.cvbird.cvbirdpromoemailservice.controller;

import ai.cvbird.cvbirdpromoemailservice.dto.EmailDTO;
import ai.cvbird.cvbirdpromoemailservice.model.Email;
import ai.cvbird.cvbirdpromoemailservice.service.EmailService;
import ai.cvbird.cvbirdpromoemailservice.service.EmailServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/promo/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveEmail(@RequestBody @Valid EmailDTO emailDTO){
        Email email = emailService.save(emailDTO);
        if (email != null) {
            return new ResponseEntity<>(email.getEmail(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(null, HttpStatus.ALREADY_REPORTED);
        }
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
