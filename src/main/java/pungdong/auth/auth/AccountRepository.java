package pungdong.auth.auth;


import org.springframework.data.jpa.repository.JpaRepository;
import pungdong.auth.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
