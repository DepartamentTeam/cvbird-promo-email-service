package ai.cvbird.cvbirdpromoemailservice.dto;

import ai.cvbird.cvbirdpromoemailservice.entity.EmailDetails;
import ai.cvbird.cvbirdpromoemailservice.model.Feedback;
import org.springframework.stereotype.Component;

@Component
public class FeedbackConverter {

    public Feedback fromDTO(FeedbackDTO feedbackDTO) {
        Feedback feedback = new Feedback();
        feedback.setId(feedbackDTO.getId());
        feedback.setTopic(feedbackDTO.getTopic());
        feedback.setName(feedbackDTO.getName());
        feedback.setEmail(feedbackDTO.getEmail().toLowerCase());
        feedback.setMessage(feedbackDTO.getMessage());
        return feedback;
    }

    public FeedbackDTO toDTO(Feedback feedback) {
        FeedbackDTO feedbackDTO = new FeedbackDTO();
        feedbackDTO.setId(feedback.getId());
        feedbackDTO.setTopic(feedback.getTopic());
        feedbackDTO.setName(feedback.getName());
        feedbackDTO.setEmail(feedback.getEmail());
        feedbackDTO.setMessage(feedback.getMessage());
        return feedbackDTO;
    }

    public EmailDetails toEmailDetails(FeedbackDTO feedbackDTO) {
        EmailDetails emailDetails = new EmailDetails();
        emailDetails.setMsgBody(feedbackDTO.toString());
        return emailDetails;
    }
}
