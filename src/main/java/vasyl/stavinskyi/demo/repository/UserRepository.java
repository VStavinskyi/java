package vasyl.stavinskyi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vasyl.stavinskyi.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findAllByEmailAndPassword(String email, String password);
    public User findUserById (Long id);



}