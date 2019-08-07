package vasyl.stavinskyi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vasyl.stavinskyi.demo.dto.request.RestaurantRequest;
import vasyl.stavinskyi.demo.dto.response.RestaurantResponse;
import vasyl.stavinskyi.demo.entity.Restaurant;
import vasyl.stavinskyi.demo.repository.RestaurantRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private UserService userService;

    public void create(RestaurantRequest request) {
        restaurantRepository.save(restaurantRequestToRestaurant(null, request));
    }

    public List<RestaurantResponse> findAll() {

        return restaurantRepository.findAll().stream()
                .map(RestaurantResponse::new)
                .collect(Collectors.toList());

    }

    public Restaurant findOne(Long id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant with id " + id + " not exists"));
    }

    public List<Restaurant> findAllByUser(Long userId) {
        return restaurantRepository.findAllByUser(userService.findOne(userId));
    }

    public void update(Long id, RestaurantRequest request) {
        restaurantRepository.save(restaurantRequestToRestaurant(findOne(id), request));
    }

    public void delete(Long id) {
        restaurantRepository.delete(findOne(id));
    }

    private Restaurant restaurantRequestToRestaurant(Restaurant restaurant, RestaurantRequest request) {
        if (restaurant == null) {
            restaurant = new Restaurant();
        }
        restaurant.setName(request.getName());
        restaurant.setAddress(request.getAddress());
        restaurant.setUser(userService.findOne(request.getUserId()));
        return restaurant;
    }

}


