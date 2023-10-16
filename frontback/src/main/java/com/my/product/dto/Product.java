package com.my.product.dto;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable{
	private String prodNo; //comment(주석)상품번호
	private String prodName; //상품이름
	transient private int prodPrice; //상품가격
	
	public Product() {

	}
	public Product(String prodNo,String prodName,int prodPrice ) {
		this.prodNo=prodNo;
		this.prodName=prodName;
		this.prodPrice=prodPrice;
	}

	public void print() {
		System.out.println(this.getProdNo()+":"+this.getProdName()+":"+this.getProdPrice());
	}


	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		if(prodNo.charAt(0)=='S' || prodNo.length()>10) {
			System.out.println("싱품번호가 잘못되었습니다.");
			return ;		
		}
		this.prodNo = prodNo;
	}

	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(prodNo);
	}
	@Override
	/**
	 * @param obj 상품객체
	 * @return 현재객체의 상품번호와 obj객체의 상품번호가 같으면 true반환, 그외는 false반환
	 * ex) equals(new String()); 결과 false
	 * ex) equals(null); 결과 false
	 * */
	public boolean equals(Object obj) {
		if(obj !=null && obj instanceof Product) {
			Product p=(Product)obj;
			if(this.prodNo !=null) { //p(상품자체)가 null이거나	
				return this.prodNo.equals(p.prodNo);
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "Product [prodNo=" + prodNo + ", prodName=" + prodName + ", prodPrice=" + prodPrice + "]";
	}
	

	/*
	public boolean equals(Object obj) {
		if (this == obj) //같은 객체면
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())// 클래스타입 갖지 않으면
			return false;
		Product other = (Product) obj; //상품번호로 비교해야 하므로, Object클래스에는 prodNo라는 맴버변수가없어서 downcasting
		return Objects.equals(prodNo, other.prodNo);
		//위와 같은 뜻 this.prodNo.equals(other.prodNo);
	}
	 */


}
