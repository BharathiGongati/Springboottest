package org.jsp.SpringBootTest.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootTest.dto.Product;
import org.jsp.SpringBootTest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);

	}

	public Product updateProduct(Product product) {
		return repository.save(product);

	}

	public Optional<Product> findById(int id) {
		return repository.findById(id);

	}

	public boolean deleteProduct(int id) {
		Optional<Product> recProduct = findById(id);
		if (recProduct.isPresent()) {
			repository.delete(recProduct.get());
			return true;
		}
		return false;

	}

//	public List<Product> findProductsByUserId(int user_id) {
//		return repository.findProductsByMerchantId(user_id);
//	}


	

}
