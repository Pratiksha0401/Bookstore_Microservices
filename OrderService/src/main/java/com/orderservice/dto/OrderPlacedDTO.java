package com.orderservice.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class OrderPlacedDTO {

	@NotNull
	private String sucess;
}