package com.paymentSystem.payment.service;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paymentSystem.payment.dto.ResponseDto;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Override
	public ResponseEntity<ResponseDto> fetchData(Map<Object, Object> requestData) {
		ObjectMapper mapper = new ObjectMapper();
		ResponseDto dto = mapper.convertValue(requestData, ResponseDto.class);
		return new ResponseEntity<ResponseDto>(checkType(dto), HttpStatus.OK);
	}
	
	private ResponseDto checkType(ResponseDto dto) {
		switch(dto.getPaymentType()){
		case "Physical Product":{
			dto.setStatus("Packaging Slip Generated");
		}
		
		break;
		case "Book":{
			dto.setStatus("Duplicate Packaging Slip created for royality department");
		}
		break;
		case "Activate Membership":{
			dto.setStatus("Membership Activated");
		}
		break;
		case "Upgrade Membership":{
			dto.setStatus("Membership Upgrade Applied");
		}
		break;
		case "Activate or Upgrade":{
			dto.setStatus("Email sent to owner with membership status");
		}
		break;
		case "learn to Ski":{
			dto.setStatus("Adding learning to SKi and First Aid video to packaging slip");
		}
		break;
		case "Physical Product or Book":{
			dto.setStatus("Commission payment generated to the agent");
		}
		break;
		}
		return dto;
	}

}
