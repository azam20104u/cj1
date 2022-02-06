package com.yash.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.product.dao.ProductDAO;
import com.yash.product.model.ProductDTO;

@WebServlet("/ViewProductServlet")
public class ViewProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		ProductDAO dao=new ProductDAO();
		List<ProductDTO> dtos=dao.getProducts();
		writer.print("<h3 align='center'><table border='1'>"+
				"<tr>"+
				"<th>Product Name</th>"+
				"<th>Product Price</th>"+
				"<th>Brand Name</th>"+
				"<th>Edit/Update</th>"+
				"<th>Delete</th>"+
				"<th>Add to Cart</th>"+
				"</tr>");
		
		for (ProductDTO dto : dtos) {
			writer.print(
					"<tr>"+
					"<td>"+dto.getName()+"</td>"+
					"<td>"+dto.getPrice()+"</td>"+
					"<td>"+dto.getBrand()+"</td>"+
					"<td><a href='EditServlet?id="+dto.getId()+"'>Edit</a></td>"+
					"<td><a href='DeleteServlet?id="+dto.getId()+"'>Delete</a></td>"+
					"<td><a href='AddCartServlet?id="+dto.getId()+"'>Add to Cart</a></td>"+
					"</tr>");
		}
		writer.print("</table></h3>");	
	}
}
