package org.jsp.SpringBootTest.service;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootTest.dao.MerchantDao;
import org.jsp.SpringBootTest.dao.MerchantDao;
import org.jsp.SpringBootTest.dto.ResponseStructure;
import org.jsp.SpringBootTest.dto.Merchant;
import org.jsp.SpringBootTest.exception.IdNotFoundExcepton;
import org.jsp.SpringBootTest.exception.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
	@Autowired
	private MerchantDao dao;
	
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(Merchant u){
		ResponseStructure<Merchant> structure=new ResponseStructure<>();
		structure.setData(dao.saveMerchant(u));
		structure.setMessage("Merchant saved with Id:"+u.getId());
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(Merchant u){
		ResponseStructure<Merchant> structure=new ResponseStructure<>();
		structure.setData(dao.updateMerchant(u));
		structure.setMessage("Merchant updated");
		structure.setStatuscode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.ACCEPTED);
		
	}
	
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(long phone,String password){
		ResponseStructure<Merchant> structure=new ResponseStructure<>();
		Optional<Merchant> recMerchant=dao.verifyMerchant(phone,password);
		if(recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMessage("Merchant verified succesfully");
			structure.setStatuscode(HttpStatus.OK.value());
			return  new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
			
		}
		throw new InvalidCredentialsException();
		
	}
	public ResponseEntity<ResponseStructure<Merchant>>  findById(int id){
		ResponseStructure<Merchant> structure=new ResponseStructure<>();
		Optional<Merchant> recMerchant=dao.findById(id);
		if(recMerchant.isPresent()) {
			structure.setData(recMerchant.get());
			structure.setMessage("Merchant verified succesfully");
			structure.setStatuscode(HttpStatus.OK.value());
			return  new ResponseEntity<ResponseStructure<Merchant>>(structure,HttpStatus.OK);
			
		}
		throw new IdNotFoundExcepton();
		
		
	}
	
}

