package ai.cvbird.cvbirdpromoemailservice.dao;

import ai.cvbird.cvbirdpromoemailservice.model.UserEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEmailRepository extends JpaRepository<UserEmail, Long> {
    public UserEmail findByEmail(String email);
}
