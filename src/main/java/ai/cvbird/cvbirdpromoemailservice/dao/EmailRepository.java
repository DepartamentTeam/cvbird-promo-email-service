package ai.cvbird.cvbirdpromoemailservice.dao;

import ai.cvbird.cvbirdpromoemailservice.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
    public Email findByEmail(String email);
}
