package dev.gabbriellps.producer.service;

import dev.gabbriellps.producer.service.interfaces.StringProducerService;
import dev.gabbriellps.producer.service.producer.StringProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StringProducerServiceImpl implements StringProducerService {

    private final StringProducer producer;

    @Override
    public void produceString(String message) {
        producer.sendMessage(message);
    }

}
