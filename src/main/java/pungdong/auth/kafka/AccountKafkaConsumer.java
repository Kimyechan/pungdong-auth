package pungdong.auth.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pungdong.auth.auth.AccountRepository;
import pungdong.auth.domain.Account;

@Service
@RequiredArgsConstructor
public class AccountKafkaConsumer {
    private final AccountRepository accountRepository;

    @KafkaListener(topics = "account", groupId = "group_id")
    public void consume(AccountTokenInfo accountTokenInfo) {
        Account account = Account.builder()
                .id(Long.valueOf(accountTokenInfo.getId()))
                .password(accountTokenInfo.getPassword())
                .roles(accountTokenInfo.getRoles())
                .build();

        accountRepository.save(account);
    }
}
