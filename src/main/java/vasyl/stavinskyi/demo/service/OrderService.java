package vasyl.stavinskyi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vasyl.stavinskyi.demo.dto.request.OrderRequest;
import vasyl.stavinskyi.demo.dto.request.ProductCountRequest;
import vasyl.stavinskyi.demo.dto.response.OrderResponse;
import vasyl.stavinskyi.demo.entity.Order;
import vasyl.stavinskyi.demo.entity.ProductCount;
import vasyl.stavinskyi.demo.repository.OrderRepository;
import vasyl.stavinskyi.demo.repository.ProductCountRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductCountRepository productCountRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private PlaceService placeService;

    @Autowired
    private WorkerService workerService;

    public void create(OrderRequest request) {
        saveProductsCount(orderRepository.save(orderRequestToOrder(null, request)), request);
    }

    public List<OrderResponse> findAll() {

        return orderRepository.findAll().stream()
                .map(OrderResponse::new)
                .collect(Collectors.toList());

    }

    public void update(Long id, OrderRequest request) {
        saveProductsCount(orderRepository.save(orderRequestToOrder(findOne(id), request)), request);
    }

    public void delete(Long id) {
        orderRepository.delete(findOne(id));
    }

    public Order findOne(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Order with id " + id + " not exists"));
    }

    public Order findOpenOrdersByPlace(Long placeId) {
        return orderRepository.findAllByClosedAndAndPlace(false, placeService.findOne(placeId));
    }

    public Order findOrderByClosedAndPlace(Long placeId) {
        return orderRepository.findOrderByClosedAndPlace(false, placeService.findOne(placeId));
    }

    private Order orderRequestToOrder(Order order, OrderRequest request) {

        if (order == null) {
            order = new Order();
            order.setDate(LocalDate.now());
            order.setTime(LocalTime.now());
        }
        order.setClosed(request.getClosed());
        order.setSum(request.getSum());
        order.setDiscount(request.getDiscount());
        order.setPlace(placeService.findOne(request.getPlaceId()));
        order.setWorkers(request.getWorkersId().stream()
            .map(workerService::findOne)
            .collect(Collectors.toSet())
        );
        return order;
    }

    private void saveProductsCount(Order order, OrderRequest request) {
        productCountRepository.deleteAll(order.getProductCounts());
        List<ProductCount> productCountList = request.getProducts().stream()
                .map(p -> productCountRequestToProductCount(order, p))
                .collect(Collectors.toList());
        productCountRepository.saveAll(productCountList);

    }

    private ProductCount productCountRequestToProductCount(Order order, ProductCountRequest request) {
        return ProductCount.builder()
                .count(request.getCount())
                .order(order)
                .product(productService.findOne(request.getProductId()))
                .build();
    }


}


