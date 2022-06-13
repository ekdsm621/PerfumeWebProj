package common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import category.CategoryDAO;
import category.CategoryDTO;
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
		
		// 네비게이션 카테고리 던지기
		CategoryDAO cateDao = new CategoryDAO();
		Map<String, List<String>> allCate = cateDao.getAllCategory();
		request.setAttribute("allCate", allCate);
		
		if(path.equals("/index.do")) {
			// 인덱스 페이지에 필요한 데이터 실어서 index.jsp로 보내기
			System.out.println("인덱스 페이지");
			List<ProductDTO> newProducts = new ArrayList<ProductDTO>();
			List<ProductDTO> bestProducts = new ArrayList<ProductDTO>();
			ProductDAO dao = new ProductDAO();
			newProducts = dao.getNewProducts();
			bestProducts = dao.getBestProducts();
			request.setAttribute("newProducts", newProducts);
			request.setAttribute("bestProducts", bestProducts);
			request.getRequestDispatcher("/index.jsp").forward(request,response);
			
		}else if(path.equals("/maincate.do")) {
			// 카테고리별 상품 가져와서 넘겨주기
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
			
		}else if(path.equals("/login.do")) {
			// 로그인 처리
			String from = request.getParameter("from");
			from = from.substring(0,from.lastIndexOf("."))+".do";
			System.out.println("로그인 처리");
			MemberDTO dto = new MemberDTO();
			MemberDAO dao = new MemberDAO();
			dto.setId(request.getParameter("id"));
			dto.setPw(request.getParameter("pw"));
			
			MemberDTO user = dao.getMember(dto);
			if(user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("id", user.getId());
				response.sendRedirect(from);
			}
			
		} else if (path.equals("/logout.do")) {
			// 로그아웃 처리
			String from = request.getParameter("from");
			from = from.substring(0,from.lastIndexOf("."))+".do";
			System.out.println("로그아웃 처리");
			HttpSession session = request.getSession();
			session.removeAttribute("id");
			response.sendRedirect(from);
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
			
			response.sendRedirect("/index.do");
		}else if (path.equals("/cart.do")) {
			request.getRequestDispatcher("/cart.jsp").forward(request,response);
		}else if (path.equals("/detail.do")) {
			// 디테일 페이지
			System.out.println("디테일 페이지");
			int id = Integer.parseInt(request.getParameter("id"));
			ProductDAO dao = new ProductDAO();
			ProductDTO dto = dao.getProdDetail(id);
			if(dto == null) {
				// 에러 페이지
			}else {
				request.setAttribute("detail", dto);
				request.getRequestDispatcher("/detail.jsp").forward(request,response);				
			}
			
		}
	}
}
