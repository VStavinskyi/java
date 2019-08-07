package vasyl.stavinskyi.demo.dto.response;

import lombok.Getter;
import lombok.Setter;
import vasyl.stavinskyi.demo.entity.Place;

@Getter
@Setter
public class PlaceResponse {
    private Long id;
    private Integer number;
    private RestaurantResponse restaurant;

    public PlaceResponse(Place place) {
        id = place.getId();
        number = place.getNumber();
        restaurant = new RestaurantResponse(place.getRestaurant());
    }
}
