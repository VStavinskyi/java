package vasyl.stavinskyi.demo.dto.response;

import lombok.Getter;
import lombok.Setter;
import vasyl.stavinskyi.demo.entity.Product;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private Integer price;
    private Integer calorie;
    private String recipe;

    public ProductResponse(Product product) {
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        calorie = product.getCalorie();
        recipe = product.getRecipe();
    }
}
