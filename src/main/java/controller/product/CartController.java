package controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import product.ProductDAO;
import product.ProductDTO;

@WebServlet("/cart.do")
public class CartController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		// 카트 페이지 띄우기
		if (session.getAttribute("cart") != null) {
			// 장바구니에 아이템 있는 경우
			Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
			Set<String> cartIds = cart.keySet();

			// 카트 페이지에 넘겨줄 변수
			List<ProductDTO> cartItem = new ArrayList<>();
			int totalPrice = 0;
			ProductDTO item = null;

			ProductDAO dao = new ProductDAO();
			for (String cartId : cartIds) {
				item = dao.getCartItem(cartId);
				item.setQuantity(cart.get(cartId));
				cartItem.add(item);
				totalPrice += item.getPrice() * item.getQuantity();
			}
			request.setAttribute("cartExist", 1);
			request.setAttribute("cartItem", cartItem);
			request.setAttribute("totalPriceStr", item.priceStr(totalPrice));
			request.setAttribute("totalPriceWithShipStr", item.priceStr(totalPrice + 2500));
		} else {
			// 장바구니에 아이템 없는 경우
			request.setAttribute("cartExist", "-1");
		}
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
	}
}
