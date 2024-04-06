package ai.cvbird.cvbirdpromoemailservice.dao;

import ai.cvbird.cvbirdpromoemailservice.model.GoogleUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoogleUserRepository extends JpaRepository<GoogleUser, Long> {

    public GoogleUser findByGoogleEmail(String googleEmail);
}
