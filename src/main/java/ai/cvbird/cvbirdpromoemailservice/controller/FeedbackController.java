package ai.cvbird.cvbirdpromoemailservice.controller;

import ai.cvbird.cvbirdpromoemailservice.dto.FeedbackConverter;
import ai.cvbird.cvbirdpromoemailservice.dto.FeedbackDTO;
import ai.cvbird.cvbirdpromoemailservice.entity.EmailDetails;
import ai.cvbird.cvbirdpromoemailservice.model.Feedback;
import ai.cvbird.cvbirdpromoemailservice.service.EmailService;
import ai.cvbird.cvbirdpromoemailservice.service.FeedbackStoreService;
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
@RequestMapping("/feedback")
@CrossOrigin
public class FeedbackController {
    @Autowired
    FeedbackStoreService feedbackStoreService;

    @Autowired
    EmailService emailService;

    @Autowired
    FeedbackConverter feedbackConverter;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveAndSendFeedback(@RequestBody FeedbackDTO feedbackDTO){
        Feedback feedback = feedbackStoreService.save(feedbackDTO);
        EmailDetails emailDetails = feedbackConverter.toEmailDetails(feedbackDTO);
        String status = emailService.sendSimpleMail(emailDetails);
        return new ResponseEntity<>(status, HttpStatus.OK);

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
