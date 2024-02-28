package br.com.alurafood.payment.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alurafood.payment.DTO.PaymentDTO;
import br.com.alurafood.payment.service.PaymentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	@GetMapping
	public Page<PaymentDTO> findAll (@PageableDefault(size = 10) Pageable pagination) {
		
		return service.findAll(pagination);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PaymentDTO> details(@PathVariable @NotNull Long id) {
		PaymentDTO dto = service.findById(id);
		
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<PaymentDTO> created(@RequestBody @Valid PaymentDTO dto, UriComponentsBuilder uriBuilder) {
		PaymentDTO payment = service.created(dto);
		URI address = uriBuilder.path("/payments/{id}").buildAndExpand(payment.getId()).toUri();
		
		return ResponseEntity.created(address).body(payment);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PaymentDTO> update(@PathVariable @NotNull Long id, @RequestBody @Valid PaymentDTO dto) {
		PaymentDTO updated = service.updatePayment(id, dto);
		
		return ResponseEntity.ok(updated);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<PaymentDTO> delete(@PathVariable @NotNull Long id) {
		service.deletePayment(id);
		return ResponseEntity.noContent().build();
	}

}
