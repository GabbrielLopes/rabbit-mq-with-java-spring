package dev.gabbriellps.producer.service.interfaces;

import dev.gabbriellps.dto.ProductDTO;

public interface StringProducerService {

    void produceString(String message);

    void produceProductDTO(ProductDTO productDTO);

}
