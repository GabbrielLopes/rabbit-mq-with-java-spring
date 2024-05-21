package dev.gabbriellps.consumer.service.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StringConsumer {


    @RabbitListener(queues = {"product.log"})
    public void consumeStringLog(String message){
        log.info("One message received: {}", message);
    }

    @RabbitListener(queues = {"product.pdf"})
    public void consumePdf(String message){
        log.info("Generating PDF: {}", message);
    }

}
