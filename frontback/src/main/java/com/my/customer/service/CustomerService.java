package com.my.customer.service;

import com.my.customer.dao.CustomerRepository;
import com.my.customer.dto.Customer;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.product.dto.Product;
public class CustomerService {
	private static CustomerService service=new CustomerService();
	private CustomerRepository repository;

	private CustomerService() {
		repository=new CustomerRepository();
	}
	public static CustomerService getInstance() {
		return service;
	}
	/**
	 * 
	 * 상품목록을 검색한다
	 * @param currentPage 검색할 페이지
	 * 
	 * @return 페이지에 해당하는 상품목록
	 * throws FindException DB와의 연결실패 또는 SQL구문오류시 예외발생한다
	 * */
	

	public void signup(Customer c) throws AddException{
		
		try {
			repository.insert(c);
		} catch (AddException e) {
			throw new AddException("회원 가입 실패");
		}
		
		
		
		
	}
	public void idDupChk(String id) throws FindException{
		Customer c=null;
		try {
			//id에 해당 고객이 있는 경우(중복인 경우)
			c=repository.selectById(id);
		
			
		}catch(FindException e) { 
			//id에 해당 고객이 없는 경우(id 사용가능한 경우)
			
		}
		
		if(c!=null) {
			throw new FindException("이미 사용중인 아이디입니다");
		}
	}
	public Customer login(String id, String pwd) 
		throws FindException{
			Customer c= repository.selectById(id);
			if(pwd.equals(c.getPwd())){
				return c;
			}else {
				throw new FindException("로그인 실패");
			}
		}
	}


