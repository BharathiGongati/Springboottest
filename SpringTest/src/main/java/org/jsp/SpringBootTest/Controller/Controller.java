package org.jsp.SpringBootTest.Controller;

import java.util.List;

import org.jsp.SpringBootTest.dto.Merchant;
import org.jsp.SpringBootTest.dto.ResponseStructure;
import org.jsp.SpringBootTest.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	private MerchantService service;

	@PostMapping("/Merchants")
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant u) {

		return service.saveMerchant(u);

	}

	@PutMapping("/Merchants")
	public ResponseEntity<ResponseStructure<Merchant>> UpdateMerchant(@RequestBody Merchant u) {

		return service.updateMerchant(u);

	}

	@PostMapping("/Merchants/verifyByphone")
	public ResponseEntity<ResponseStructure<Merchant>> verifyMerchant(@RequestParam long phone,
			@RequestParam String password) {

		return service.verifyMerchant(phone, password);
	}
	@PutMapping("/Merchants/{id}")
	public ResponseEntity<ResponseStructure<Merchant>> UpdateMerchant(@PathVariable int id ) {

		return service.findById(id);

	}
	

}
