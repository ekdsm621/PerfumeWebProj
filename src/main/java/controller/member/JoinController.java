package controller.member;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import category.CategoryDAO;
import member.MemberDAO;
import member.MemberDTO;

@WebServlet("/join.do")
public class JoinController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 회원가입 처리
		System.out.println("회원가입 처리");
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();

		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.setBirth(request.getParameter("birth"));
		dto.setGender(request.getParameter("gender"));
		dto.setEmail(request.getParameter("email") + "@" + request.getParameter("email_behind"));
		if (request.getParameter("email_agree") == null || request.getParameter("email_agree").equals("")) {
			dto.setEmail_agree(0);
		} else {
			dto.setEmail_agree(1);
		}
		dto.setPhone(request.getParameter("number_first") + request.getParameter("number_second")
				+ request.getParameter("number_third"));
		if (request.getParameter("phone_agree") == null || request.getParameter("phone_agree").equals("")) {
			dto.setPhone_agree(0);
		} else {
			dto.setPhone_agree(1);
		}
		dto.setPost(request.getParameter("post"));
		dto.setAddress(request.getParameter("address"));

		dao.insertMember(dto);

		response.sendRedirect("/index.do");

	}
}
