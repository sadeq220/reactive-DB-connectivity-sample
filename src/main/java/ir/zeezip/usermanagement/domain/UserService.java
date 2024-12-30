package ir.zeezip.usermanagement.domain;

import ir.zeezip.usermanagement.infrastructure.UserRepository;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
public class UserService implements UserPort {
    private final UserRepository userRepository;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    public UserService(UserRepository userRepository, R2dbcEntityTemplate r2dbcEntityTemplate) {
        this.userRepository = userRepository;
        this.r2dbcEntityTemplate = r2dbcEntityTemplate;
    }

    @Override
    @Transactional
    public Mono<UserValue> saveUser(String username, String name, String email) {
        UserDomain userDomain = new UserDomain();
        userDomain.setId(username);
        userDomain.setEmail(email);
        userDomain.setName(name);
        Mono<UserDomain> savedDomain = r2dbcEntityTemplate.insert(userDomain);
        return savedDomain.map(userDomain1 -> new UserValue(userDomain1.getId(), userDomain1.getEmail()));
    }
}
