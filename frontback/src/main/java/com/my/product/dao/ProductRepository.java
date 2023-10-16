package com.my.product.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.my.exception.FindException;
import com.my.product.dto.Product;
import com.my.sql.MyConnection;

public class ProductRepository {
	private SqlSessionFactory sessionFactory;
	public ProductRepository(){
		String resource = "/mybatisconfig/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Product selectByProdNo(String prodNo) throws FindException {
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();// Connection과 같은 뜻
			Product p = session.selectOne("com.my.customer.mapper.ProductMapper.selectByProdNo", prodNo);
			if (p == null) {
				throw new FindException("상품이 없습니다");
			}else {
				System.out.println("p.prodNo="+p.getProdNo()+", p.prodName="+p.getProdName()+", p.prodPrice="+p.getProdPrice());

				return p;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if (session != null) {
				session.close(); // DBCP에게 Connection돌려줌
			}
		}

		//		Connection conn = null;
		//		PreparedStatement pstmt = null;
		//		ResultSet rs = null;
		//		Product p;
		//		try {
		//			conn = MyConnection.getConnection();		
		//			String selectSQL = "SELECT * FROM product WHERE prod_no=?";		
		//			
		//			pstmt = conn.prepareStatement(selectSQL);
		//			pstmt.setString(1, prodNo);
		//			rs = pstmt.executeQuery();
		//			
		//			rs.next();
		//			String no=rs.getString("prod_no");
		//			String name=rs.getString("prod_name");
		//			try {
		//			int price=rs.getInt("prod_price");
		//			return new Product(no,name,price);
		//			
		//			}catch(NullPointerException e) {
		//				return new Product(no,name,0);
		//			}
		//			
		//			
		//		} catch (ClassNotFoundException | SQLException e) {
		//			e.printStackTrace();
		//			throw new FindException(e.getMessage());
		//		} finally {
		//			MyConnection.close(rs, pstmt, conn);
		//		}

	}
	public int count() throws FindException{
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();// Connection과 같은 뜻
			int cnt = session.selectOne("com.my.customer.mapper.ProductMapper.count");

			System.out.println("cnt="+cnt);		        	 
			return cnt;

		} catch (Exception e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			if (session != null) {
				session.close(); // DBCP에게 Connection돌려줌
			}
		}
	}  

	//		
	//		
	//		//1.DB와의 연결
	//		Connection conn = null;
	//		try {
	//			conn = MyConnection.getConnection();
	//		}catch(ClassNotFoundException | SQLException e) {
	//			e.printStackTrace();
	//			throw new FindException("DB와의 연결 실패:" + e.getMessage());
	//		}
	//		//2.SQL구문 송신
	//		String selectCountSQL = "SELECT COUNT(*) FROM product";
	//		PreparedStatement pstmt = null;
	//		ResultSet rs = null;
	//		try {
	//			pstmt = conn.prepareStatement(selectCountSQL);
	//			rs = pstmt.executeQuery();
	//			rs.next();
	//			return rs.getInt(1);			
	//		} catch (SQLException e) {
	//			e.printStackTrace();
	//			throw new FindException(e.getMessage());
	//		} finally {
	//			MyConnection.close(rs, pstmt, conn);
	//		}
	//		
	//	}
	//	/**
	//	 * 상품목록을 검색한다
	//	 * @param startRow 시작행
	//	 * @param endRow 끝행
	//	 * @return 상품목록
	//	 * @throws FindException DB와의 연결실패 또는 SQL구문오류시 예외발생한다 
	//	 */
	public List<Product> selectAll(int startRow, int endRow) 
			throws FindException{
		List<Product> list = new ArrayList<>();
		SqlSession session = null;
		try {
			session = sessionFactory.openSession();// Connection과 같은 뜻
			Map<String, Integer> map=new HashMap<>();
			map.put("startRow", startRow);
			map.put("endRow", endRow);

			list=session.selectList("com.my.customer.mapper.ProductMapper.selectAll",map);
			return list;
		}catch(Exception e) {

			throw new FindException("상품검색 실패:" + e.getMessage());
		}finally {
			if (session != null) {
				session.close(); // DBCP에게 Connection돌려줌
			}
		}
	}
}
