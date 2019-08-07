package vasyl.stavinskyi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import vasyl.stavinskyi.demo.entity.Place;
import vasyl.stavinskyi.demo.entity.Restaurant;


@Repository
public interface PlaceRepository extends JpaRepository<Place, Long>, JpaSpecificationExecutor<Place> {
    public Place findAllByRestaurant(Restaurant restaurant);
}