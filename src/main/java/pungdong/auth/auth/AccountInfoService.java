package pungdong.auth.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pungdong.auth.domain.Account;

@Service
@RequiredArgsConstructor
public class AccountInfoService implements UserDetailsService {
    private final AccountRepository accountRepository;


    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        Account account = accountRepository.findById(Long.valueOf(id)).orElseThrow();

        if (account == null) {
            throw new UsernameNotFoundException("wrongId");
        }

        return new AccountInfo(account);
    }
}
