package vasyl.stavinskyi.demo.dto.response;

import lombok.Getter;
import lombok.Setter;
import vasyl.stavinskyi.demo.entity.Restaurant;
import vasyl.stavinskyi.demo.entity.User;

import java.util.Set;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private String username;
    private String password;
    private String email;

    public UserResponse(User user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
        email = user.getEmail();
    }

}