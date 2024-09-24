package az.bank.msorder.entity;

import az.bank.msorder.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderEntity {

    @Id //it is compulsory for all entities
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long clientId;
    LocalDateTime orderDate;

    Integer status;

    @OneToMany(mappedBy = "order" , cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
    List<OrderDetailEntity> orderDetails;

    @PrePersist
    public void assignDefaultValue() {
        orderDate = LocalDateTime.now();
        status = StatusEnum.ACTIVE.getStatus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
