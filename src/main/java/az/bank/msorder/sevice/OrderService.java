package az.bank.msorder.sevice;

import az.bank.msorder.enums.StatusEnum;
import az.bank.msorder.entity.OrderDetailEntity;
import az.bank.msorder.entity.OrderEntity;
import az.bank.msorder.exception.NotFoundException;
import az.bank.msorder.mapper.OrderDetailMapper;
import az.bank.msorder.mapper.OrderMapper;
import az.bank.msorder.model.request.SaveOrderToDbRequest;
import az.bank.msorder.model.response.GetOrderByIdResponse;
import az.bank.msorder.repository.OrderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true , level =  AccessLevel.PRIVATE)
public class OrderService {

    OrderRepository orderRepository;
    OrderMapper orderMapper;
    OrderDetailMapper orderDetailMapper;

    public void saveOrderToDb(SaveOrderToDbRequest request) {
        OrderEntity orderEntity = orderMapper.toOrderEntity(request);
        List<OrderDetailEntity> orderDetails = request.getOrderDetails().stream()
                .map(orderDetailMapper::toOrderDetailEntity)
                .collect(Collectors.toList());
        for (OrderDetailEntity orderDetail : orderDetails){
            orderDetail.setOrder(orderEntity);
        }
        orderEntity.setOrderDetails(orderDetails);
        orderRepository.save(orderEntity);
    }
    public GetOrderByIdResponse getOrderById(Long id) {
        return orderMapper.toGetOrderByIdResponse(fetchOrderById(id));
    }

    private OrderEntity fetchOrderById(Long id){
        return orderRepository.getOrderEntitiesByIdAndStatus(id , StatusEnum.ACTIVE.getStatus())
                .orElseThrow(() -> new NotFoundException("there is no Order with " + id + " id.." , HttpStatus.NOT_FOUND.value() , LocalDateTime.now()));
    }

    public void deleteOrderById(Long id) {
        OrderEntity orderEntity = fetchOrderById(id);
        orderEntity.setStatus(StatusEnum.DE_ACTIVE.getStatus());
        orderRepository.save(orderEntity);
    }

}
