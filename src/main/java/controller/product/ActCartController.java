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

@WebServlet("/actcart.do")
public class ActCartController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// delete 肚绰 order 贸府
		if (request.getParameter("act") != null && request.getParameter("checkedId") != null) {
			String act = request.getParameter("act");
			String[] ids = request.getParameterValues("checkedId");
			if (act.equals("delete")) {
				// delete 夸没
				session.removeAttribute("");
				Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
				for (String id : ids) {
					cart.remove(id);
				}
				if (cart.size() == 0) {
					cart = null;
				}
				session.setAttribute("cart", cart);
				response.sendRedirect("/cart.do");
			} else {
				// order 夸没
			}
		}
	}

}
