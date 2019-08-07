package vasyl.stavinskyi.demo.dto.response;

import lombok.Getter;
import lombok.Setter;
import vasyl.stavinskyi.demo.entity.ProductCount;

@Getter
@Setter
public class ProductCountResponse {
    private Long id;
    private Integer count;
    private ProductResponse productResponse;

    public ProductCountResponse(ProductCount productCount) {
        id = productCount.getId();
        count = productCount.getCount();
        productResponse = new ProductResponse(productCount.getProduct());
    }
}
