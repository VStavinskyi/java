package vasyl.stavinskyi.demo.dto.response;

import lombok.Getter;
import lombok.Setter;
import vasyl.stavinskyi.demo.entity.Order;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class OrderResponse {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private Boolean closed;
    private Integer sum;
    private Integer discount;
    private PlaceResponse place;
    private Set<WorkerResponse> workers;
    private List<ProductCountResponse> products;

    public OrderResponse (Order order) {
        id = order.getId();
        date = order.getDate();
        time = order.getTime();
        closed = order.getClosed();
        sum = order.getSum();
        discount = order.getDiscount();
        place = new PlaceResponse(order.getPlace());
        workers = order.getWorkers().stream().map(WorkerResponse::new).collect(Collectors.toSet());
        products = order.getProductCounts().stream().map(ProductCountResponse::new).collect(Collectors.toList());
    }


}
