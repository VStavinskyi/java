package vasyl.stavinskyi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vasyl.stavinskyi.demo.dto.request.UserRequest;
import vasyl.stavinskyi.demo.dto.response.UserResponse;
import vasyl.stavinskyi.demo.service.UserService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void create(@RequestBody UserRequest request) {
        userService.create(request);
    }

    @GetMapping
    public List<UserResponse> findAll() {
        return userService.findAll();
    }

    @GetMapping("/exist")
    public Boolean exist(String email, String password) {
        return userService.userExist(email, password);
    }

    @GetMapping("/getByEmailAndPassword")
    public UserResponse getByEmailAndPassword(String email, String password) {
        return new UserResponse(userService.getByEmailAndPassword(email, password));
    }

    @GetMapping("/getCurrent")
    public UserResponse getCurrent(Long id) {
        return new UserResponse(userService.findOne(id));
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody UserRequest request) throws IOException {userService.update(id, request); }

    @DeleteMapping
    public void delete(Long id) {
        userService.delete(id);
    }

}