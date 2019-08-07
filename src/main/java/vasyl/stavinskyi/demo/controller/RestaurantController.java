package vasyl.stavinskyi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import vasyl.stavinskyi.demo.dto.request.RestaurantRequest;
import vasyl.stavinskyi.demo.dto.response.OrderResponse;
import vasyl.stavinskyi.demo.dto.response.RestaurantResponse;
import vasyl.stavinskyi.demo.dto.response.WorkerResponse;
import vasyl.stavinskyi.demo.service.RestaurantService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public void create(@RequestBody RestaurantRequest request) {
        restaurantService.create(request);
    }

    @GetMapping
    public List<RestaurantResponse> findAll() {
        return restaurantService.findAll();
    }

    @GetMapping("/allByUser")
    public List<RestaurantResponse> findAllByUser(Long userId) {
        return restaurantService.findAllByUser(userId).stream().map(RestaurantResponse::new).collect(Collectors.toList());
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody RestaurantRequest request) throws IOException {restaurantService.update(id, request); }

    @DeleteMapping
    public void delete(Long id) {
        restaurantService.delete(id);
    }

}