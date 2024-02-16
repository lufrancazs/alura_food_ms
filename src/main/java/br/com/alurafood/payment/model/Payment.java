package br.com.alurafood.payment.model;

import java.math.BigDecimal;

import br.com.alurafood.payment.enums.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Positive
	private BigDecimal valor;
	
	@NotBlank
	@Size(max = 100)
	private String name;
	
	@NotBlank
	@Size(max = 19)
	private String number;
	
	@NotBlank
	@Size(max = 7)
	private String expiration;
	
	@NotBlank
	@Size(min = 3, max = 3)
	private String code;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@NotNull
	private Long orderId;
	@NotNull
	private Long formeOfPayment;

}
