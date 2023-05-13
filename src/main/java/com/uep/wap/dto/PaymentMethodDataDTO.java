package com.uep.wap.dto;

import java.util.List;

public class PaymentMethodDataDTO {

    List<PaymentMethodDTO> paymentMethodDTOList;


    public List<PaymentMethodDTO> getPaymentMethodDTOList(){
        return paymentMethodDTOList;
    }

    public void setPaymentMethodDTOList(List<PaymentMethodDTO> paymentMethodDTOList) {
        this.paymentMethodDTOList = paymentMethodDTOList;
    }
}
