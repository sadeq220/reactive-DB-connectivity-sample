package ir.zeezip.usermanagement.domain;

import reactor.core.publisher.Mono;

public interface UserPort {
    Mono<UserValue> saveUser(String username, String name, String email);
}
