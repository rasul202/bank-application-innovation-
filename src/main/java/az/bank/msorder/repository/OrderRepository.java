package az.bank.msorder.repository;

import az.bank.msorder.entity.OrderEntity;
import org.apache.commons.text.translate.NumericEntityUnescaper;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity , Long> {

    @EntityGraph(attributePaths = {"orderDetails"} , type = EntityGraph.EntityGraphType.FETCH)
    public Optional<OrderEntity>  getOrderEntitiesByIdAndStatus(Long id , Integer status);

}
