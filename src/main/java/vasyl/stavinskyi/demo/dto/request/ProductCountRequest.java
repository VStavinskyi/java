package vasyl.stavinskyi.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductCountRequest {
    private Long productId;
    private Integer count;
}
