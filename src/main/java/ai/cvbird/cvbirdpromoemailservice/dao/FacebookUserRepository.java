package ai.cvbird.cvbirdpromoemailservice.dao;

import ai.cvbird.cvbirdpromoemailservice.model.FacebookUser;
import ai.cvbird.cvbirdpromoemailservice.model.Feedback;
import ai.cvbird.cvbirdpromoemailservice.model.UserEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacebookUserRepository extends JpaRepository<FacebookUser, Long> {
    public FacebookUser findByEmail(String email);
}