package vasyl.stavinskyi.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class OrderRequest {
    private Boolean closed;
    private Integer sum;
    private Integer discount;
    private Long placeId;
    private Set<Long> workersId;
    private List<ProductCountRequest> products;
}
