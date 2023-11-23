package org.jsp.SpringBootTest.Controller;

import java.util.List;


import org.jsp.SpringBootTest.dto.Product;
import org.jsp.SpringBootTest.dto.ResponseStructure;
import org.jsp.SpringBootTest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;

	@PostMapping("/products/{user_id}")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product,
			@PathVariable int user_id) {
		return service.saveProduct(product, user_id);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
//
//	@GetMapping("/products/byuser-id/{id}")
//	public ResponseEntity<ResponseStructure<List<Product>>> findProductsByMerchantId(@PathVariable int id) {
//		return service.findProductsByMerchantId(id);
//	}

}
