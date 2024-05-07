package sazondelbueno.web.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sazondelbueno.web.Model.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account getByEmailAndPassword(String email, String password);
}
