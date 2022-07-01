package controller.product;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

@WebServlet("/setcart.do")
public class SetCartController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 카트에 담기
		String id = request.getParameter("id");
		int amount = Integer.parseInt(request.getParameter("amount"));
		// id, 갯수로 구성
		Map<String, Integer> cart = null;
		HttpSession session = request.getSession();

		if (session.getAttribute("cart") != null) {
			// 카트가 존재하는 경우
			cart = (Map<String, Integer>) session.getAttribute("cart");
			Set<String> cartIds = cart.keySet();
			boolean exist = false;
			for (String cartId : cartIds) {
				// 카트 내 동일 상품이 있는지 검색
				if (cartId.equals(id)) {
					exist = true;
					break;
				}
			}
			if (exist) {
				// 존재하는 경우 -> 동일한 아이템이 장바구니에 존재 -> 갯수 ++
				int cartCount = cart.get(id);
				cartCount += amount;
				cart.replace(id, cartCount);
			} else {
				// 카트에 존재하지 않는 경우
				cart.put(id, amount);
			}
		} else {
			// 카트가 존재하지 않는 경우
			cart = new HashMap<>();
			cart.put(id, amount);
			session.setAttribute("cart", cart);
		}
		
		response.getWriter().println(1);

//		response.sendRedirect("/detail.do?id=" + id);

	}
}
