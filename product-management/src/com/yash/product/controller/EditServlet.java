package com.yash.product.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.product.dao.ProductDAO;
import com.yash.product.model.ProductDTO;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String stId = request.getParameter("id");
		int id=Integer.parseInt(stId);
		
		ProductDAO dao=new ProductDAO();
		ProductDTO product = dao.editProduct(id);
		
		writer.print("<h1 align='center/>Update Product</h1>"+
					 "<hr>"+
					 "<h3 align='center'>"+
					 "<form action='UpdateProductServlet' method='post'>"+
								"<input type='hidden' name='id' value='"+product.getId()+"'><br>"+
								"<input type='text' name='name' value='"+product.getName()+"'><br>"+
								"<input type='number' name='price' value='"+product.getPrice()+"'><br>"+
								"<input type='text' name='brand' value='"+product.getBrand()+"'><br>"+
								"<input type='submit' value='Update Product'>"+
							"</form>"+
						"</h3>");
	}
}
