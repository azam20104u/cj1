package com.yash.product.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.product.dao.ProductDAO;
import com.yash.product.model.ProductDTO;

@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {

	List<ProductDTO> liDtos=new ArrayList<ProductDTO>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		String stId = request.getParameter("id");
		int id = Integer.parseInt(stId);

		ProductDAO dao = new ProductDAO();
		ProductDTO product = dao.editProduct(id);
		liDtos.add(product);
		HttpSession session=request.getSession();
		
		session.setAttribute("listOfProduct", liDtos);
		
		writer.print("Item added successfully<br>"
				+ "<a href='CartServlet'>Cart Details<a>");
		
	}

}
