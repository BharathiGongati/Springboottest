package org.jsp.SpringBootTest.service;

import java.util.List;

import java.util.Optional;

import org.jsp.SpringBootTest.dao.ProductDao;
import org.jsp.SpringBootTest.dao.MerchantDao;
import org.jsp.SpringBootTest.dto.Merchant;
import org.jsp.SpringBootTest.dto.Product;
import org.jsp.SpringBootTest.dto.ResponseStructure;
import org.jsp.SpringBootTest.exception.IdNotFoundExcepton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;




@Service
public class ProductService {
	@Autowired
	private ProductDao dao;

	@Autowired
	private MerchantDao MerchantDao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product, int user_id) {
		Optional<Merchant> recUser = MerchantDao.findById(user_id);
		ResponseStructure<Product> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			Merchant u = recUser.get();
			u.getProducts().add(product);

			product.setMerchant(recUser.get());
			MerchantDao.updateMerchant(recUser.get());
			dao.saveProduct(product);
			structure.setData(product);
			structure.setMessage("product added successfully");
			structure.setStatuscode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED);

		}
		throw new IdNotFoundExcepton();
	}

	public ResponseEntity<ResponseStructure<String>> deleteProduct(int id) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		Optional<Product> recProduct = dao.findById(id);
		if (recProduct.isPresent()) {
			dao.deleteProduct(id);
			structure.setData("product deleted");
			structure.setMessage("Product Found");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundExcepton();
	}

//	public ResponseEntity<ResponseStructure<List<Product>>> findProductsByMerchantId(int user_id) {
//		ResponseStructure<List<Product>> structure = new ResponseStructure<>();
//		structure.setData(dao.findProductsByUserId(user_id));
//		structure.setMessage("products found for User Id");
//		structure.setStatuscode(HttpStatus.OK.value());
//		return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.OK);
//	}
	

	
	
	
	


	

}
