package com.paymentSystem.payment.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.paymentSystem.payment.dto.ResponseDto;

public interface PaymentService {

	ResponseEntity<ResponseDto> fetchData(Map<Object, Object> requestData);

}
