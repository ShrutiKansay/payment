package com.paymentSystem.payment.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentSystem.payment.dto.ResponseDto;
import com.paymentSystem.payment.service.PaymentService;

@RestController
@RequestMapping(path ="/payment")
@CrossOrigin("*")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@PostMapping(path ="/fetchdata", produces="application/json")
	public ResponseEntity<ResponseDto> fetchData(@RequestBody Map<Object, Object> requestData){
		return paymentService.fetchData(requestData);
	}

}
