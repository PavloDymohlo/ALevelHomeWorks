package ua.dymohlo.hibernetpractic;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "graduate")
@Table(schema = "alevelgraduates", name = "orders3")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nameOrder")
    private String nameOrder;

    @Column(name = "serialNumber")
    private int serialNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "graduate")
    private Graduate graduate;
}
