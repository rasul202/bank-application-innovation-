package az.bank.msorder.controller;

import az.bank.msorder.model.request.SaveOrderToDbRequest;
import az.bank.msorder.model.response.GetOrderByIdResponse;
import az.bank.msorder.sevice.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("orders")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true , level =  AccessLevel.PRIVATE)
public class OrderController {

    OrderService orderService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrderToDb(@RequestBody SaveOrderToDbRequest request){
        orderService.saveOrderToDb(request);
    }

    @GetMapping("/retrieve/{id}")
    public GetOrderByIdResponse getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderById(@PathVariable Long id){
        orderService.deleteOrderById(id);
    }

}
