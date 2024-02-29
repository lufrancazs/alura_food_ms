package br.com.alurafood.payment.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
	
	private List<OrderItem> itens;

}
