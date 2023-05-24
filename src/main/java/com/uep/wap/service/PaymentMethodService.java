package com.uep.wap.service;


import com.uep.wap.dto.PaymentMethodDTO;
import com.uep.wap.model.PaymentMethod;
import com.uep.wap.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    public void addPaymentMethod(PaymentMethodDTO paymentMethodDTO) {
        PaymentMethod paymentMethod= new PaymentMethod();
        paymentMethod.setMethod_name(paymentMethodDTO.getMethod_name());
        paymentMethodRepository.save(paymentMethod);
        System.out.println("Payment Method added!");
    }

    public Iterable<PaymentMethod> getAllPaymentMethod(){
        return paymentMethodRepository.findAll();
    }
}
