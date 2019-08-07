package vasyl.stavinskyi.demo.dto.response;

import lombok.Getter;
import lombok.Setter;
import vasyl.stavinskyi.demo.entity.Restaurant;

@Getter
@Setter
public class RestaurantResponse {
    private Long id;
    private String name;
    private String address;
    private UserResponse user;

    public RestaurantResponse(Restaurant restaurant) {
        id = restaurant.getId();
        name = restaurant.getName();
        address = restaurant.getAddress();
        user = new UserResponse(restaurant.getUser());
    }
}