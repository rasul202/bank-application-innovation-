package az.bank.msorder.mapper;

import az.bank.msorder.entity.OrderDetailEntity;
import az.bank.msorder.entity.OrderEntity;
import az.bank.msorder.model.request.SaveOrderDetailToDbRequest;
import az.bank.msorder.model.request.SaveOrderToDbRequest;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring" ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderDetailMapper {

    OrderDetailEntity toOrderDetailEntity(SaveOrderDetailToDbRequest request);

}
