package ir.zeezip.usermanagement.application;

import ir.zeezip.usermanagement.application.dto.UserInputDto;
import ir.zeezip.usermanagement.application.dto.UserOutputDto;
import ir.zeezip.usermanagement.domain.UserPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserPort userPort;

    public UserController(UserPort userPort) {
        this.userPort = userPort;
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<UserOutputDto>> saveUser(@RequestBody UserInputDto userInputDto){
        return userPort.saveUser(userInputDto.getUsername(), userInputDto.getName(), userInputDto.getEmail()).map(userValue -> {
            UserOutputDto userOutputDto = new UserOutputDto();
            userOutputDto.setId(userValue.id());
            userOutputDto.setEmail(userValue.email());
            return ResponseEntity.ok(userOutputDto);
        });
    }
}
