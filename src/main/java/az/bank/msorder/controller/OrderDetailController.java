package az.bank.msorder.controller;

import az.bank.msorder.model.request.SaveOrderDetailToDbRequest;
import az.bank.msorder.sevice.OrderDetailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order-details")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true , level =  AccessLevel.PRIVATE)
public class OrderDetailController {

    OrderDetailService orderDetailService;

    @PostMapping("create")
    public void saveOrderDetailToDb(@RequestBody SaveOrderDetailToDbRequest request){
        orderDetailService.saveOrderDetailToDb(request);
    }



}
