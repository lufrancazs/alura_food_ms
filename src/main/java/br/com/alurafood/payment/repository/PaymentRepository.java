package br.com.alurafood.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alurafood.payment.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
