package vasyl.stavinskyi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vasyl.stavinskyi.demo.entity.Restaurant;
import vasyl.stavinskyi.demo.entity.User;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    public List<Restaurant> findAllByUser(User user);
}