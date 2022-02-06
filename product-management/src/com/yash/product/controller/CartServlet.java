package com.yash.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.product.model.ProductDTO;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		request.getRequestDispatcher("index.html").include(request, response);
		HttpSession session=request.getSession(false);
		List<ProductDTO> list= (List<ProductDTO>) session.getAttribute("listOfProduct");
		writer.print("<br>");
		for (ProductDTO productDTO : list) {
			writer.print(productDTO.getName()+" "+productDTO.getPrice()+"<br>");
		}
		
	}
}
