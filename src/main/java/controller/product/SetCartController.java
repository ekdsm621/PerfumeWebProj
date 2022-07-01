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
		// īƮ�� ���
		String id = request.getParameter("id");
		int amount = Integer.parseInt(request.getParameter("amount"));
		// id, ������ ����
		Map<String, Integer> cart = null;
		HttpSession session = request.getSession();

		if (session.getAttribute("cart") != null) {
			// īƮ�� �����ϴ� ���
			cart = (Map<String, Integer>) session.getAttribute("cart");
			Set<String> cartIds = cart.keySet();
			boolean exist = false;
			for (String cartId : cartIds) {
				// īƮ �� ���� ��ǰ�� �ִ��� �˻�
				if (cartId.equals(id)) {
					exist = true;
					break;
				}
			}
			if (exist) {
				// �����ϴ� ��� -> ������ �������� ��ٱ��Ͽ� ���� -> ���� ++
				int cartCount = cart.get(id);
				cartCount += amount;
				cart.replace(id, cartCount);
			} else {
				// īƮ�� �������� �ʴ� ���
				cart.put(id, amount);
			}
		} else {
			// īƮ�� �������� �ʴ� ���
			cart = new HashMap<>();
			cart.put(id, amount);
			session.setAttribute("cart", cart);
		}
		
		response.getWriter().println(1);

//		response.sendRedirect("/detail.do?id=" + id);

	}
}
