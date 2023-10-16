package com.my.order.dto;
import com.my.product.dto.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class OrderLine {
	private int orderNo;
//	private String orderProdNo;
	private Product orderP;
	private int orderQuantity;
	

}
