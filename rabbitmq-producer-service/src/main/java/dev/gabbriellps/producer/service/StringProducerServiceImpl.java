package dev.gabbriellps.producer.service;

import dev.gabbriellps.dto.ProductDTO;
import dev.gabbriellps.producer.config.RabbitMQConfig;
import dev.gabbriellps.producer.service.interfaces.StringProducerService;
import dev.gabbriellps.producer.service.producer.ProductProducer;
import dev.gabbriellps.producer.service.producer.StringProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StringProducerServiceImpl implements StringProducerService {

    private final StringProducer stringProducer;
    private final ProductProducer productProducer;
    private final AmqpAdmin amqpAdmin;


    @Override
    public void produceString(String message) {
        stringProducer.sendMessage(message);
    }

    @Override
    public void produceProductDTO(ProductDTO productDTO) {
        productProducer.sendMessageToRabbit(productDTO);
    }

}
