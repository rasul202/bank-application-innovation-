package az.bank.msorder.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveOrderDetailToDbRequest {

    Long productId;
    Integer quantity;
    BigDecimal price;

}
