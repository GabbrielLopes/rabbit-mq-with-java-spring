package dev.gabbriellps.producer.service;

import dev.gabbriellps.producer.config.RabbitMQConfig;
import dev.gabbriellps.producer.service.interfaces.StringProducerService;
import dev.gabbriellps.producer.service.producer.StringProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StringProducerServiceImpl implements StringProducerService {

    private final StringProducer producer;
    private final AmqpAdmin amqpAdmin;


    @Override
    public void produceString(String message) {
        // Cria nova fila e vinculo de teste, para o consumidor receber mensagens de filas diferentes
        Queue queue = new Queue(RabbitMQConfig.QUEUE_PRODUCT_PDF, false, false, false);
        amqpAdmin.declareQueue(queue);
        Binding newBinding = RabbitMQConfig.createNewBinding(queue,
                new DirectExchange(RabbitMQConfig.EXG_NAME_MARKETPLACE), RabbitMQConfig.RK_PRODUCT_PDF);

        amqpAdmin.declareBinding(newBinding);

        producer.sendMessage(message);
        producer.sendMessagePdf(message);
    }

}
