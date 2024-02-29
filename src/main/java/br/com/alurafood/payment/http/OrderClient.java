package br.com.alurafood.payment.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alurafood.payment.model.Order;

@FeignClient("orders-ms")
public interface OrderClient {
	
	@RequestMapping(method = RequestMethod.PUT, value = "/orders/{id}/paid")
	void updatePayment(@PathVariable Long id);
	
	@RequestMapping(method = RequestMethod.GET, value = "/orders/{id}")
	Order findAllOrderItems(@PathVariable Long id);

}
