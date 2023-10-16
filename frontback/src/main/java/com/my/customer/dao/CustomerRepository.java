package com.my.customer.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.my.customer.dto.Customer;
import com.my.exception.AddException;
import com.my.exception.FindException;

public class CustomerRepository {
   private SqlSessionFactory sessionFactory;

   public CustomerRepository() {
      String resource = "/mybatisconfig/mybatis-config.xml";
      InputStream inputStream;
      try {
         inputStream = Resources.getResourceAsStream(resource);
         sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void insert(Customer c) throws AddException {
	   SqlSession session=null;
	   try {
		   session=sessionFactory.openSession();
		   //session.insert("com.my.customer.mapper.CustomerMapper.insert", c);
		   Map<String, String> map=new HashMap<>();
		   map.put("i", c.getId());
		   map.put("p", c.getPwd());
		   map.put("n", c.getName());
		   
		   session.insert("com.my.customer.mapper.CustomerMapper.insert", map);
		   session.commit(); //실제 반영되게 해야함. 스프링마이바티스 사용하는게 아니라 수동으로 해줘야함
	   }catch(Exception e) {
		   e.printStackTrace();
		   throw new AddException(e.getMessage());
	   }finally {
		   if(session!=null) {
			   session.close();
		   }
	   }
//      Connection conn = null;
//      try {
//         conn = MyConnection.getConnection();
//      } catch (ClassNotFoundException | SQLException e) {
//         e.printStackTrace();
//         throw new AddException(e.getMessage());
//      }
//      String insertSQL = "INSERT INTO customer(id, pwd, name) VALUES (?,?,?)";
//      PreparedStatement pstmt = null;
//      try {
//         pstmt = conn.prepareStatement(insertSQL);
//         pstmt.setString(1, c.getId());
//         pstmt.setString(2, c.getPwd());
//         pstmt.setString(3, c.getName());
//         pstmt.executeUpdate();
//      } catch (SQLException e) {
//         e.printStackTrace();
//         throw new AddException(e.getMessage());
//      } finally {
//         MyConnection.close(null, pstmt, conn);
//      }
   }

   public Customer selectById(String id) throws FindException {
      SqlSession session = null;
      try {
         session = sessionFactory.openSession();// Connection과 같은 뜻
         Customer c = session.selectOne("com.my.customer.mapper.CustomerMapper.selectById", id);
         if (c == null) {
            throw new FindException("고객이 없습니다");
         }
         System.out.println("c.id="+c.getId()+", c.pwd="+c.getPwd()+", c.name="+c.getName());
         return c;
      } catch (Exception e) {
         e.printStackTrace();
         throw new FindException(e.getMessage());
      } finally {
         if (session != null) {
            session.close(); // DBCP에게 Connection돌려줌
         }
      }
   }
}