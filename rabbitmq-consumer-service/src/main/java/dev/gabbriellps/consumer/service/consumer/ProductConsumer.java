package dev.gabbriellps.consumer.service.consumer;

import dev.gabbriellps.consumer.rabbit.QueueConstants;
import dev.gabbriellps.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductConsumer {

    @RabbitListener(queues = {QueueConstants.RK_PRODUCT_PDF})
    public void consumePdf(ProductDTO message){
        log.info("Generating PDF with data: {}", message.toString());
    }

}
