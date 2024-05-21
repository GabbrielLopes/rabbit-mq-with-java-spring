package dev.gabbriellps.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXG_NAME_MARKETPLACE = "marketplace.direct";
    public static final String QUEUE_PRODUCT_LOG = "product.log";
    public static final String RK_PRODUCT_LOG = "product.log";


    public static final String QUEUE_PRODUCT_PDF = "product.pdf";
    public static final String RK_PRODUCT_PDF = "product.pdf";


    private AmqpAdmin amqpAdmin;

    public RabbitMQConfig(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_PRODUCT_LOG, false, false, false);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXG_NAME_MARKETPLACE, false, false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(directExchange())
                .with(RK_PRODUCT_LOG);
    }

    public static Binding createNewBinding(Queue queue, DirectExchange directExchange, String bindingKey) {
        return BindingBuilder
                .bind(queue)
                .to(directExchange)
                .with(bindingKey);
    }

//    @Bean
//    public void create(){
//        this.amqpAdmin.declareBinding(binding());
//    }


}
