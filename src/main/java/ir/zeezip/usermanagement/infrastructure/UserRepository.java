package ir.zeezip.usermanagement.infrastructure;

import ir.zeezip.usermanagement.domain.UserDomain;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends R2dbcRepository<UserDomain,String> {

}
