package br.com.alurafood.payment.DTO;

import java.math.BigDecimal;
import java.util.List;

import br.com.alurafood.payment.enums.PaymentStatus;
import br.com.alurafood.payment.model.OrderItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {
	
	private Long id;
	private BigDecimal valor;
	private String nome;
	private String numero;
	private String expiracao;
	private String codigo;
	private PaymentStatus status;
	private Long pedidoId;
	private Long formaDePagamentoId;
	private List<OrderItem> itens;

}
