package br.com.alurafood.payment.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItem {
	
	private Long id;
	private Integer quantidade;
	private String descricao;

}
