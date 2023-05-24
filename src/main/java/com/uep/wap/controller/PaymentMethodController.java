package com.uep.wap.controller;

import com.uep.wap.dto.PaymentMethodDTO;
import com.uep.wap.model.PaymentMethod;
import com.uep.wap.service.PaymentMethodService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/paymentMethodController")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    public PaymentMethodController(PaymentMethodService paymentMethodService) { this.paymentMethodService = paymentMethodService;}

    @GetMapping(path = "/getPaymentMethods")
    public Iterable<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodService.getAllPaymentMethod();
    }

    @PostMapping(path = "/addPaymentMethod")
    public String addPaymentMethod(@RequestBody PaymentMethodDTO paymentMethodDTO){
        paymentMethodService.addPaymentMethod(paymentMethodDTO);
        return "Payment Method added!";
    }
}
