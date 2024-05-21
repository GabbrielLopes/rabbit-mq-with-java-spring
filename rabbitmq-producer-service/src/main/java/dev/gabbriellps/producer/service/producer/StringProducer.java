package dev.gabbriellps.producer.service.producer;

import dev.gabbriellps.producer.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static dev.gabbriellps.producer.config.RabbitMQConfig.EXG_NAME_MARKETPLACE;
import static dev.gabbriellps.producer.config.RabbitMQConfig.RK_PRODUCT_LOG;

@Component
@RequiredArgsConstructor
@Slf4j
public class StringProducer {


    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(String msg){
        log.info("Receveid message: {}", msg);

        try {
            rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_LOG, msg);
            log.info("Message sent successfully!");
        } catch (AmqpException e){
            log.error("Error send message - {}", e.getMessage());
        }
    }

}
