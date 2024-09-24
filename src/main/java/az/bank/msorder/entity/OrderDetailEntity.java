package az.bank.msorder.entity;

import az.bank.msorder.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "order_details")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailEntity {

    @Id //it is compulsory for all entities
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long productId;
    Integer quantity;
    BigDecimal price;

    Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    OrderEntity order;

    @PrePersist
    public void setDefaults(){
        status = StatusEnum.ACTIVE.getStatus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailEntity that = (OrderDetailEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
