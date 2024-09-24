package az.bank.msorder.mapper;

import az.bank.msorder.entity.OrderEntity;
import az.bank.msorder.model.request.SaveOrderToDbRequest;
import az.bank.msorder.model.response.GetOrderByIdResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring" ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OrderMapper {

    @Mapping(target = "orderDetails" , ignore = true)
    public OrderEntity toOrderEntity(SaveOrderToDbRequest request);

    GetOrderByIdResponse toGetOrderByIdResponse(OrderEntity orderEntity);

}
