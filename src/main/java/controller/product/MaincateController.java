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

import common.Paging;
import product.ProductDAO;
import product.ProductDTO;

@WebServlet("/maincate.do")
public class MaincateController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("카테고리별 상품 넘겨주기");
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		String maincate = request.getParameter("maincate");
		if(maincate == null) {
			maincate = "FRAGRANCES";
		}
		String subcate = request.getParameter("subcate");
		String page = request.getParameter("page");
		String pagegroup = request.getParameter("pagegroup");
		ProductDAO dao = new ProductDAO();
		products = dao.getCateProducts(maincate, subcate, page, pagegroup);
		request.setAttribute("products", products);
		
		// 페이징처리 위한 값 넘겨주기
		Map<String,Integer> paging = Paging.getPaging(dao.totalCateProducts(maincate, subcate), page, pagegroup);
		request.setAttribute("paging", paging);
	
		request.getRequestDispatcher("/maincate.jsp").forward(request,response);
	}
}
