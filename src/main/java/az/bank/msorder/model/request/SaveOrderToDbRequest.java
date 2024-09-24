package az.bank.msorder.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.aop.target.LazyInitTargetSource;

import java.lang.ref.PhantomReference;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SaveOrderToDbRequest {

    Long clientId;
    List<SaveOrderDetailToDbRequest> orderDetails;

}
