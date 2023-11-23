package org.jsp.reservation.repository;

import org.jsp.reservation.dto.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	

}