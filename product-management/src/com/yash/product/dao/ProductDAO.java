package com.yash.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yash.product.model.ProductDTO;

public class ProductDAO {
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cj1?user=root&password=root");
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
	public void add(ProductDTO dto) {
		try {
			Connection con = getConnection();
			PreparedStatement pst = con.prepareStatement("insert into product values(?,?,?,?)");
			pst.setInt(1, dto.getId());
			pst.setString(2, dto.getName());
			pst.setInt(3, dto.getPrice());
			pst.setString(4, dto.getBrand());
			pst.execute();
			System.out.println("data added");
		} catch (SQLException e) {
		}
	}
	public List<ProductDTO> getProducts() {
		Connection connection = getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select* from product");
			List<ProductDTO> list=new ArrayList<>();
			while (resultSet.next()) {
				ProductDTO dto=new ProductDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setName(resultSet.getString("name"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setBrand(resultSet.getString("brand"));
				list.add(dto);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public ProductDTO editProduct(int id) {
		Connection connection = getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select* from product where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			ProductDTO dto=new ProductDTO();
			dto.setId(resultSet.getInt("id"));
			dto.setName(resultSet.getString("name"));
			dto.setPrice(resultSet.getInt("price"));
			dto.setBrand(resultSet.getString("brand"));
			return dto;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public int update(ProductDTO dto) {
		Connection connection = getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("update product set name=?, price=?, brand=? where id=?");
			prepareStatement.setString(1, dto.getName());
			prepareStatement.setInt(2, dto.getPrice());
			prepareStatement.setString(3, dto.getBrand());
			prepareStatement.setInt(4, dto.getId());
			int update = prepareStatement.executeUpdate();
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
