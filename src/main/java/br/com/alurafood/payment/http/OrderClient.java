package br.com.alurafood.payment.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.alurafood.payment.model.Order;

@FeignClient("orders-ms")
public interface OrderClient {
	

	@PutMapping("/orders/{id}/paid")
	void updatePayment(@PathVariable Long id);
	
	
	@GetMapping("/orders/{id}")
	Order findAllOrderItems(@PathVariable Long id);

}
