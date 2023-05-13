package com.uep.wap.dto;

import java.util.List;

public class DeliveryOptionDataDTO {

    public List<DeliveryOptionDTO> deliveryOptionDTOList;


    public List<DeliveryOptionDTO> getDeliveryOptionDTO() {
        return deliveryOptionDTOList;
    }

    public void setDeliveryOptionDTO(List<DeliveryOptionDTO> deliveryOptionDTOList) {
        this.deliveryOptionDTOList = deliveryOptionDTOList;
    }
}
