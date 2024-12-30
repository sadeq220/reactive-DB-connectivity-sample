package ir.zeezip.usermanagement.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "USER_INFO")
@Data
public class UserDomain {
    @Id
    @Column("id")
    private String id;

    @Column("name")
    private String name;

    @Column("email")
    private String email;

}
