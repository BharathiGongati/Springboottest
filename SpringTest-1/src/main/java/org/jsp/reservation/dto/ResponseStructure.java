package org.jsp.reservation.dto;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private T data;
	private String messege;
	private int statuscode;
}
