package dev.gabbriellps.producer.service.producer;

import dev.gabbriellps.dto.ProductDTO;
import dev.gabbriellps.producer.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static dev.gabbriellps.producer.config.RabbitMQConfig.EXG_NAME_MARKETPLACE;
import static dev.gabbriellps.producer.config.RabbitMQConfig.RK_PRODUCT_PDF;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductProducer {

    private final RabbitTemplate rabbitTemplate;


    public void sendMessageToRabbit(ProductDTO productDTO) {
        log.info("Producer receveid a message: {}", productDTO.toString());
        try {
            rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RK_PRODUCT_PDF, productDTO);
            log.info("Message Product sent successfully!");
        } catch (AmqpException e){
            log.error("Error to send message Product!");
        }
    }

}
