package vasyl.stavinskyi.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vasyl.stavinskyi.demo.dto.request.OrderRequest;
import vasyl.stavinskyi.demo.dto.response.OrderResponse;
import vasyl.stavinskyi.demo.service.OrderService;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public void create(@RequestBody OrderRequest request) {
        orderService.create(request);
    }

    @GetMapping
    public List<OrderResponse> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/current")
    public OrderResponse findOne(Long id) {
        return new OrderResponse(orderService.findOne(id));
    }

    @GetMapping("/byTableId")
    public OrderResponse findOneByPlace(Long placeId) {
        return new OrderResponse(orderService.findOrderByClosedAndPlace(placeId));
    }

    @PutMapping
    public void update(Long id, @Valid @RequestBody OrderRequest request) throws IOException {orderService.update(id, request); }

    @DeleteMapping
    public void delete(Long id) {
        orderService.delete(id);
    }

}


