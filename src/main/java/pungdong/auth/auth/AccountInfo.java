package pungdong.auth.auth;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import pungdong.auth.domain.Account;
import pungdong.auth.domain.Role;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class AccountInfo extends User {
    private Account account;

    public AccountInfo(Account account) {
        super(String.valueOf(account.getId()), account.getPassword(), authorities(account.getRoles()));
        this.account = account;
    }

    private static Collection<? extends GrantedAuthority> authorities(Set<Role> roles) {
        return roles.stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.name()))
                .collect(Collectors.toList());
    }
}
