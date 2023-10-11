package edu.co.poli.taller.services;

import edu.co.poli.taller.maper.DeliveryInDTOToDelivery;
import edu.co.poli.taller.persistence.entity.Delivery;
import edu.co.poli.taller.persistence.repository.DeliveryRepository;
import edu.co.poli.taller.services.dto.DeliveryInDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeliveryImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final DeliveryInDTOToDelivery deliveryInDTOToDelivery;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Delivery save(DeliveryInDTO delivery) {
        return deliveryRepository.save(deliveryInDTOToDelivery.mapper(delivery));
    }

    @Override
    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public void delete(Delivery delivery) {
        deliveryRepository.delete(delivery);
    }

    @Override
    public Delivery findById(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    @Override
    public Delivery update(Long id, Delivery delivery) {
        Optional<Delivery> delivery1 = deliveryRepository.findById(id);
        if(delivery1.isEmpty())return null;
        Delivery delivery2 = delivery1.get();
        if(delivery.getCompany() != null) delivery2.setCompany(delivery.getCompany());
        if(delivery.getDuration() != null) delivery2.setDuration(delivery.getDuration());
        if(delivery.getType() != null) delivery2.setType(delivery.getType());
        return deliveryRepository.save(delivery2);
    }


}
