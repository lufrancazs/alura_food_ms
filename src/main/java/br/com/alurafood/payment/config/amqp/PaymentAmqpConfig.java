package br.com.alurafood.payment.config.amqp;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PaymentAmqpConfig {
	
	
	@Bean
	public RabbitAdmin createRabbitAdmin(ConnectionFactory connect) {
		return new RabbitAdmin(connect);
	}
	
	@Bean
	public ApplicationListener<ApplicationReadyEvent> startAdmin(RabbitAdmin admin){
		return event -> admin.initialize();
	}
	
	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
			Jackson2JsonMessageConverter messageConverter) {
		
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter);
		
		return rabbitTemplate;
	}
	
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("payments.ex");
	}

}
