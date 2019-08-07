package vasyl.stavinskyi.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaceCriteria {
    private Long restaurantId;

    private PaginationRequest paginationRequest;
}
