package az.bank.msorder.model.response;

import az.bank.msorder.entity.OrderDetailEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetOrderByIdResponse {

    Long clientId;
    LocalDateTime orderDate;
    List<GetOrderDetailResponse> orderDetails;

}
