package vasyl.stavinskyi.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private Integer price;
    private Integer calorie;
    private String recipe;
}
