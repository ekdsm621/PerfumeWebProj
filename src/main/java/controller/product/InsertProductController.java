package controller.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertProduct.do")
public class InsertProductController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveDirectory = request.getServletContext().getRealPath("/images/product_img/main");
		String product_name = request.getParameter("product_name");
		String product_brand = request.getParameter("product_name");
		String product_cate = request.getParameter("product_name");
		String product_price = request.getParameter("product_name");
		String product_main_img = request.getParameter("product_name");
		String product_sub_img_f = request.getParameter("product_name");
		String product_sub_img_s = request.getParameter("product_name");
		String product_sub_img_t = request.getParameter("product_name");
		String product_new = request.getParameter("product_name");
		String product_bset = request.getParameter("product_name");
	
	}
}
