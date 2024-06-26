package dev.gabbriellps.consumer.service.consumer;

import dev.gabbriellps.consumer.rabbit.QueueConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StringConsumer {

    @RabbitListener(queues = {QueueConstants.RK_PRODUCT_LOG})
    public void consumeStringLog(String message){
        log.info("One message received: {}", message);
    }

}
