package com.example.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;

@Configuration
public class RabbitConfig {

    private final RabbitProperties props;

    public RabbitConfig(RabbitProperties props) {
        this.props = props;
    }

    @Bean
    public Queue filaEnvio() {
        return new Queue(props.getFilaEnvio(), true);
    }

    @Bean
    public Queue filaRetorno() {
        return new Queue(props.getFilaRetorno(), true);
    }

	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
	    return new Jackson2JsonMessageConverter();
	}
}