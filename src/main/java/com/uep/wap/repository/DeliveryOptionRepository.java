package com.uep.wap.repository;

import com.uep.wap.model.DeliveryOption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryOptionRepository  extends CrudRepository<DeliveryOption, Integer> {
}
