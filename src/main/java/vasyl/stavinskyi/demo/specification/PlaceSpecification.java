package vasyl.stavinskyi.demo.specification;

import org.springframework.data.jpa.domain.Specification;
import vasyl.stavinskyi.demo.dto.request.PlaceCriteria;
import vasyl.stavinskyi.demo.entity.Place;
import vasyl.stavinskyi.demo.entity.Restaurant;

import javax.persistence.criteria.*;

public class PlaceSpecification implements Specification<Place> {

    private Long restaurantId;

    public PlaceSpecification(PlaceCriteria criteria) {
        restaurantId = criteria.getRestaurantId();
    }

    @Override
    public Predicate toPredicate(
            Root<Place> r, //join TABLE
            CriteriaQuery<?> cq,//select distinct, avg()
            CriteriaBuilder cb// where like FIELD, between, > <
    ) {
        Predicate byRestaurant = findByRestaurant(r, cb);
        return cb.and(byRestaurant);
    }

    private Predicate findByRestaurant(Root<Place> r, CriteriaBuilder cb) {
        Predicate predicate;
        if (restaurantId != null) {
            Join<Place, Restaurant> restaurant = r.join("restaurant");
            predicate = cb.equal(restaurant.get("id"), restaurantId);
            //r.get("id")           Product.id
            //category.get("id)     Category.id
        } else {
            predicate = cb.conjunction();
        }
        return predicate;
    }


}
