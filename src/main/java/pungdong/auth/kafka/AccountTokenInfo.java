package pungdong.auth.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pungdong.auth.domain.Role;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountTokenInfo {
    private String id;
    private String password;
    private Set<Role> roles;
}
