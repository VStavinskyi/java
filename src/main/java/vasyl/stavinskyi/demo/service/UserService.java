package vasyl.stavinskyi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vasyl.stavinskyi.demo.dto.request.UserRequest;
import vasyl.stavinskyi.demo.dto.response.UserResponse;
import vasyl.stavinskyi.demo.entity.User;
import vasyl.stavinskyi.demo.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void create(UserRequest request) {
        userRepository.save(userRequestToUser(null, request));
    }

    public List<UserResponse> findAll() {

        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());

    }

    public User findOne(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not exists"));
    }

    public User getByEmailAndPassword(String email, String password) {
        return userRepository.findAllByEmailAndPassword(email, password);
    }

    public Boolean userExist(String email, String password) {
        return userRepository.findAllByEmailAndPassword(email, password)!=null;
    }

    public void update(Long id, UserRequest request) {
        userRepository.save(userRequestToUser(findOne(id), request));
    }

    public void delete(Long id) {
        userRepository.delete(findOne(id));
    }

    private User userRequestToUser(User user, UserRequest request) {
        if (user == null) {
            user = new User();
        }
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());
        return user;
    }

}
