package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Product;


@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Product> findAllproducts() {
		
		return jdbcTemplate.query("select pid,pname,price,qty from product", (rs,num)->{
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setPrice(rs.getDouble(3));
			p.setQty(rs.getInt(4));
			return p;
		});
	}
	@Override
	public void save(Product p) {
//		String str="insert into product values(?,?,?,?)";
		jdbcTemplate.update("insert into product values(?,?,?,?)",new Object[] {p.getPid(),p.getPname(),p.getQty(),p.getPrice()});
		
		
	}
	@Override
	public Product findById(int pid) {
		try {
			Product p= jdbcTemplate.queryForObject("select * from product where pid=?",new Object[] {pid},BeanPropertyRowMapper.newInstance(Product.class));
		System.out.println("database"+p);
			return p; 
		}catch(EmptyResultDataAccessException e) {
		
		}
		return null;
	}
	@Override
	public void modifyProduct(Product product) {
		jdbcTemplate.update("update product set pname=?,qty=?,price=? where pid=?",
			new Object[] {product.getPname(),product.getQty(),product.getPrice(),product.getPid()});
		
		
	}
	@Override
	public void delete(int pid) {
		jdbcTemplate.update("delete from product where pid=?",new Object[] {pid});
		
	}

}
