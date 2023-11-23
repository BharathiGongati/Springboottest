package org.jsp.SpringBootTest.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.SpringBootTest.dto.Merchant;
import org.jsp.SpringBootTest.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
	private MerchantRepository repository;

	public Merchant saveMerchant(Merchant m) {
		return repository.save(m);
	}

	public Merchant updateMerchant(Merchant m) {
		return repository.save(m);
	}

	public Optional<Merchant> verifyMerchant(long phone, String password) {
		return repository.verifyMerchant(phone, password);
	}

	public Optional<Merchant> findById(int id) {
		
		return repository.findById(id);
	}

	

}
