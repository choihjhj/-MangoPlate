package com.my.product.service;

import java.util.List;

import com.my.exception.FindException;
import com.my.order.service.OrderService;
import com.my.product.dao.ProductRepository;
import com.my.product.dto.Product;
import com.my.util.PageBean;

public class ProductService {
	private static ProductService service=new ProductService();
	private ProductRepository repository;
	public ProductService() {
		repository = new ProductRepository();
	}
	public static ProductService getInstance() {
		return service;
	}
	public Product findByProdNo(String prodNo) throws FindException {
		Product p=new Product();
		
		try {
			p=repository.selectByProdNo(prodNo);
			return p;
		}catch(FindException e) { 
			throw new FindException("상품정보가 존재하지 않습니다.");
		}
		
	
	}
	
	/**
	 * 상품목록을 검색한다. 한페이지당 최대4개의 상품을 검색한다 
	 * @param currentPage 검색할 페이지
	 * @return 페이지에 해당하는 상품목록
	 * @throws FindException
	 */
	//public List<Product> findAll(int currentPage) throws FindException{
	public com.my.util.PageBean<Product> findAll(int currentPage) throws FindException{
		int cntPerPage = 4;
        //ex) cp :1,  2,  3
		int endRow = currentPage*cntPerPage;//        4   8   12 
		int startRow = endRow - cntPerPage + 1;//     1   5    9  
		
		List<Product> list = repository.selectAll(startRow, endRow);
		int totalCnt = repository.count(); //총 상품수
		
		int cntPerPageGroup = 3;
//		PageBean pb = new PageBean(); //롬복활용
//		pb.setCntPerPage(cntPerPage); //
//		pb.setTotalCnt(totalCnt);
//		pb.setList(list);
//		pb.setCntPerPageGroup(cntPerPageGroup);
//		pb.setCurrentPage(currentPage);
		PageBean<Product> pb = new PageBean<>(cntPerPage,
									totalCnt,
									list,
									cntPerPageGroup,
									currentPage);
		//return repository.selectAll(startRow, endRow);
		return pb;
	}
}
