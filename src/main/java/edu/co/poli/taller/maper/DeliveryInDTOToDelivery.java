package edu.co.poli.taller.maper;

import edu.co.poli.taller.persistence.entity.Delivery;
import edu.co.poli.taller.persistence.entity.Type;
import edu.co.poli.taller.services.dto.DeliveryInDTO;
import org.springframework.stereotype.Component;

@Component
public class DeliveryInDTOToDelivery implements IMaper<DeliveryInDTO, Delivery>{

    @Override
    public Delivery mapper(DeliveryInDTO in) {
        Delivery delivery = new Delivery();
        delivery.setCompany(in.getCompany());
        delivery.setDuration(in.getDuration());
        delivery.setType(Type.ORDER);
        return delivery;
    }
}
