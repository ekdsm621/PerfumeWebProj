package controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import category.CategoryDAO;
import product.ProductDAO;
import product.ProductDTO;

@WebServlet("/index.do")
public class HomeController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		
		List<ProductDTO> newProducts = new ArrayList<ProductDTO>();
		List<ProductDTO> bestProducts = new ArrayList<ProductDTO>();
		newProducts = dao.getNewProducts();
		bestProducts = dao.getBestProducts();
		
		request.setAttribute("newProducts", newProducts);
		request.setAttribute("bestProducts", bestProducts);
		request.getRequestDispatcher("/index.jsp").forward(request,response);
	}
}
