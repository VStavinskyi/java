package vasyl.stavinskyi.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "_Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private LocalTime time;

    private Boolean closed;

    private Integer sum;

    private Integer discount;

    @ManyToOne
    private Place place;

    @ManyToMany
    private Set<Worker> workers = new HashSet<>();

    @OneToMany(mappedBy = "order")
    private List<ProductCount> productCounts = new ArrayList<>();

}
