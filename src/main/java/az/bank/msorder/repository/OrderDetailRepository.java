package az.bank.msorder.repository;

import az.bank.msorder.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity , Long> {

}
