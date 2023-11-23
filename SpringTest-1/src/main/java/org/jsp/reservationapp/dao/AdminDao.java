package org.jsp.reservationapp.dao;

import org.jsp.reservation.dto.Admin;
import org.jsp.reservation.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	@Autowired
	private AdminRepository repositoty;
	
	public Admin saveAdmin(Admin admin)
	{
		return repositoty.save(admin);
	}
	public Admin updateAdmin(Admin admin)
	{
		return repositoty.save(admin);
	}

}
