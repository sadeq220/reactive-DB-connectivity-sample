package ir.zeezip.usermanagement.application.dto;

import lombok.Data;

@Data
public class UserOutputDto {
    private String id;
    private String email;
    private String name;
    private String picture;
}
