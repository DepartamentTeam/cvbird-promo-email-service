package ai.cvbird.cvbirdpromoemailservice.service;

import ai.cvbird.cvbirdpromoemailservice.dao.FeedbackRepository;
import ai.cvbird.cvbirdpromoemailservice.dto.FeedbackConverter;
import ai.cvbird.cvbirdpromoemailservice.dto.FeedbackDTO;
import ai.cvbird.cvbirdpromoemailservice.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackStoreServiceImpl implements FeedbackStoreService {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    FeedbackConverter feedbackConverter;

    @Override
    public Feedback save(FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackConverter.fromDTO(feedbackDTO);
        return feedbackRepository.save(feedback);
    }
}
