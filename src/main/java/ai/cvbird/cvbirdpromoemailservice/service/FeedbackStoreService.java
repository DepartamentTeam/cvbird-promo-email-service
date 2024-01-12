package ai.cvbird.cvbirdpromoemailservice.service;

import ai.cvbird.cvbirdpromoemailservice.dto.FeedbackDTO;
import ai.cvbird.cvbirdpromoemailservice.model.Feedback;

public interface FeedbackStoreService {
    Feedback save(FeedbackDTO feedbackDTO);
}
