package az.bank.msorder.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetOrderDetailResponse {

    Long productId;
    Integer quantity;
    BigDecimal price;

}