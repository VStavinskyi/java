package vasyl.stavinskyi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vasyl.stavinskyi.demo.entity.Order;
import vasyl.stavinskyi.demo.entity.Place;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    public Order findAllByClosedAndAndPlace(Boolean closed, Place place);
    public Order findOrderByClosedAndPlace(Boolean closed, Place place);

}