package vasyl.stavinskyi.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    @ManyToOne
    private Restaurant restaurant;

    @OneToMany(mappedBy = "place")
    private Set<Order> orders = new LinkedHashSet<>();

}
