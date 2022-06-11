package common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberDAO;
import member.MemberDTO;
import product.ProductDAO;
import product.ProductDTO;

public class DispatcherServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		if(path.equals("/index.do")) {
			// 인덱스 페이지에 필요한 데이터 실어서 index.jsp로 보내기
			System.out.println("인덱스 페이지");
			List<ProductDTO> newProducts = new ArrayList<ProductDTO>();
			List<ProductDTO> bestProducts = new ArrayList<ProductDTO>();
			ProductDAO dao = new ProductDAO();
			newProducts = dao.getNewProducts();
			bestProducts = dao.getBestProducts();
			System.out.println("객체 가져오기 성공");
			request.setAttribute("newProducts", newProducts);
			request.setAttribute("bestProducts", bestProducts);
			System.out.println("객체 요청에 등록 성공");
			request.getRequestDispatcher("/index.jsp").forward(request,response);
			
		}else if(path.equals("/login.do")) {
			// 로그인 처리
			System.out.println("로그인 처리");
			MemberDTO dto = new MemberDTO();
			MemberDAO dao = new MemberDAO();
			dto.setId(request.getParameter("id"));
			dto.setPw(request.getParameter("pw"));
			
			MemberDTO user = dao.getMember(dto);
			if(user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("id", user.getId());
				response.sendRedirect("index.jsp");
			}
			
		} else if (path.equals("/logout.do")) {
			// 로그아웃 처리
			System.out.println("로그아웃 처리");
			HttpSession session = request.getSession();
			session.removeAttribute("id");
			response.sendRedirect("index.jsp");
			
		} else if (path.equals("/join.do")) {
			// 회원가입 처리
			System.out.println("회원가입 처리");
			MemberDTO dto = new MemberDTO();
			MemberDAO dao = new MemberDAO();
						
			dto.setId(request.getParameter("id"));
			dto.setPw(request.getParameter("pw"));
			dto.setName(request.getParameter("name"));
			dto.setBirth(request.getParameter("birth"));
			dto.setGender(request.getParameter("gender"));
			dto.setEmail(request.getParameter("email") +"@"+request.getParameter("email_behind"));
			if(request.getParameter("email_agree") == null || request.getParameter("email_agree").equals("")) {
				dto.setEmail_agree(0);					
			}else {
				dto.setEmail_agree(1);			
			}
			dto.setPhone(request.getParameter("number_first")+request.getParameter("number_second")+request.getParameter("number_third"));
			if(request.getParameter("phone_agree") == null|| request.getParameter("phone_agree").equals("")) {
				dto.setPhone_agree(0);					
			}else {
				dto.setPhone_agree(1);			
			}
			dto.setPost(request.getParameter("post"));
			dto.setAddress(request.getParameter("address"));

			dao.insertMember(dto);
			
			response.sendRedirect("/index.jsp");
			
		}
	}
}
