package az.bank.msorder.sevice;

import az.bank.msorder.entity.OrderDetailEntity;
import az.bank.msorder.mapper.OrderDetailMapper;
import az.bank.msorder.model.request.SaveOrderDetailToDbRequest;
import az.bank.msorder.model.request.SaveOrderToDbRequest;
import az.bank.msorder.repository.OrderDetailRepository;
import az.bank.msorder.repository.OrderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true , level =  AccessLevel.PRIVATE)
public class OrderDetailService {

    OrderDetailRepository orderDetailRepository;
    OrderDetailMapper orderDetailMapper;

    public void saveOrderDetailToDb(SaveOrderDetailToDbRequest request) {
        orderDetailRepository.save(orderDetailMapper.toOrderDetailEntity(request));
    }

}
