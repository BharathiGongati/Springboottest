package org.jsp.SpringBootTest.repository;

import java.util.List;

import org.jsp.SpringBootTest.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
//
//	@Query("select p from Product p where p.Merchant.id=?1")
//	List<Product> findProductsByMerchantId(int user_id);

}
