package vasyl.stavinskyi.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantRequest {
    private String name;
    private String address;
    private Long userId;
}