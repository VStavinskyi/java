package vasyl.stavinskyi.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private Integer calorie;

    private String recipe;

    @OneToMany(mappedBy = "product")
    private List<ProductCount> productCounts = new ArrayList<>();

}
