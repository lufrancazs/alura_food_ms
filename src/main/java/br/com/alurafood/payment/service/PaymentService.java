package br.com.alurafood.payment.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alurafood.payment.DTO.PaymentDTO;
import br.com.alurafood.payment.enums.PaymentStatus;
import br.com.alurafood.payment.model.Payment;
import br.com.alurafood.payment.repository.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	//Buscar Todos os Pagamentos
	public Page<PaymentDTO> findAll(Pageable pagination) {
		return repository
				.findAll(pagination)
				.map (p -> modelMapper.map(p, PaymentDTO.class));
	}
	
	//Buscar Pagamento por Id
	public PaymentDTO findById(Long id){
		Payment payment = repository.findById(id).orElseThrow( () -> new EntityNotFoundException());
		
		return modelMapper.map(payment, PaymentDTO.class);
	}
	
	//Criar Pagamento
	public PaymentDTO created(PaymentDTO dto) {
		Payment payment = modelMapper.map(dto, Payment.class);
		payment.setStatus(PaymentStatus.CRIADO);
		repository.save(payment);
		
		return modelMapper.map(payment, PaymentDTO.class);
	}
	
	//Atualizar Pagamento
	public PaymentDTO updatePayment(Long id, PaymentDTO dto) {
		Payment payment = modelMapper.map(dto, Payment.class);
		payment.setId(id);
		payment = repository.save(payment);
		
		return modelMapper.map(payment, PaymentDTO.class);
	}
	
	//Excluir Pagamento
	public void deletePayment(Long id) {
		repository.deleteById(id);
	}

}
