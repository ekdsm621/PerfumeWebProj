package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.ProductDAO;
import product.ProductDTO;

@WebServlet("/admin/productList.do")
public class ProductListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		List<ProductDTO> products = dao.getProductList();
		request.setAttribute("products", products);
		request.getRequestDispatcher("/admin/productList.jsp").forward(request, response);
	}
}
