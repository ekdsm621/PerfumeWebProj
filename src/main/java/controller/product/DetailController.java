package controller.product;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.ProductDAO;
import product.ProductDTO;

@WebServlet("/detail.do")
public class DetailController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 디테일 페이지
		System.out.println("디테일 페이지");
		int id = Integer.parseInt(request.getParameter("id"));
		ProductDAO dao = new ProductDAO();
		ProductDTO dto = dao.getProdDetail(id);
		DecimalFormat dc = new DecimalFormat("###,###,###,###");
		String price = dc.format(dto.getPrice());
		String totalPrice = dc.format(dto.getPrice() + 2500);
		if (dto == null) {
			// 에러 페이지
		} else {
			request.setAttribute("totalPrice", totalPrice);
			request.setAttribute("price", price);
			request.setAttribute("detail", dto);
			request.getRequestDispatcher("/detail.jsp").forward(request, response);
		}
	}
}
