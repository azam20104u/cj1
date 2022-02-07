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

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	int id;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String name=request.getParameter("name");
		String stPrice=request.getParameter("price");
		int price=Integer.parseInt(stPrice);
		String brand=request.getParameter("brand");
		
		ProductDTO dto=new ProductDTO(++id, name, price, brand);
		
		ProductDAO dao=new ProductDAO();
		dao.add(dto);
	}
}
